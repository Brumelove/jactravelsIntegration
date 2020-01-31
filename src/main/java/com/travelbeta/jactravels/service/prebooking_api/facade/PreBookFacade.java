package com.travelbeta.jactravels.service.prebooking_api.facade;

import com.travelbeta.jactravels.service.config.TravelBetaConfig;
import com.travelbeta.jactravels.service.exception.ErrorMsg;
import com.travelbeta.jactravels.service.exception.JacTravelAPIException;
import com.travelbeta.jactravels.service.prebooking_api.payload.client.PreBookRequest;
import com.travelbeta.jactravels.service.prebooking_api.payload.client.PreBookResponse;
import com.travelbeta.jactravels.service.prebooking_api.service.PreBookingRestService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import com.travelbeta.jactravels.service.prebooking_api.util.PreBookMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * @author Brume
 **/

@Slf4j
@Service
public class PreBookFacade {
    private final TravelBetaConfig travelBetaConfig;

    private final PreBookingRestService preBookingRestService;

    private final PreBookMapperUtil preBookMapperUtl;

    private final RedisTemplate<String, PreBookResponse> redisTemplate;

    @Autowired
    public PreBookFacade(TravelBetaConfig travelBetaConfig, PreBookingRestService preBookingRestService, PreBookMapperUtil preBookMapperUtl, RedisTemplate<String, PreBookResponse> redisTemplate) {
        this.travelBetaConfig = travelBetaConfig;
        this.preBookingRestService = preBookingRestService;
        this.preBookMapperUtl = preBookMapperUtl;
        this.redisTemplate = redisTemplate;
    }




    private PreBookResponse preBookJacTravels(PreBookRequest preBookRequest) {

        val preBookHotelRequest = preBookMapperUtl.mapPreBookHotelRequest.apply(preBookRequest);

        val preBookHotelResponse = preBookingRestService.handlePreBookHotel(preBookHotelRequest);

        if (preBookHotelResponse == null) {
            return null;
        }
        if (!preBookHotelResponse.getReturnStatus().isSuccess()) {
            log.info("Exception ::: {}", preBookHotelResponse.getReturnStatus().getException());
            throw new JacTravelAPIException(ErrorMsg.INTERNAL_ERROR_TYPE, preBookHotelResponse.getReturnStatus().getException());
        }
        return preBookMapperUtl.mapPreBookRessponse.apply(preBookHotelResponse);
    }

    public PreBookResponse handlePreBook(PreBookRequest preBookRequest) {
        val redisKey = buildPreBookRequestKey(preBookRequest);
        log.info("Query Key :::: {}", redisKey);
        val isKeyAvailable = redisTemplate.hasKey(redisKey);
        PreBookResponse preBookResponse;
        if (isKeyAvailable) {
            log.info("============= Key Found in Redis Cache =========");
            return checkRedisCache(redisKey);
        } else {
            log.info("============= Key Not Found Checking API =========");
            preBookResponse = preBookJacTravels(preBookRequest);

            if (preBookResponse != null) {
                log.info("============= Updating Redis Cache with Key =========");
                val valueOperations = redisTemplate.opsForValue();
                valueOperations.set(redisKey, preBookResponse, travelBetaConfig.getCacheExpiryHours(), TimeUnit.HOURS);

                return preBookResponse;
            }
        }
        throw new JacTravelAPIException(ErrorMsg.INTERNAL_ERROR_TYPE, "Record Not Found");
    }


    private PreBookResponse checkRedisCache(String redisKey) {
        val valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(redisKey);
    }

    private String buildPreBookRequestKey(PreBookRequest preBookRequest) {
        val stringBuilder = new StringBuilder();
        return stringBuilder.append(
                preBookRequest.getArrivalDate())
                .append(preBookRequest.getDuration())
                .append(preBookRequest.getPropertyID())
                .toString();
    }
}
