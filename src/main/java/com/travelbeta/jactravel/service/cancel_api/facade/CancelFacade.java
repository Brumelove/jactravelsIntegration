package com.travelbeta.jactravel.service.cancel_api.facade;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import com.travelbeta.jactravel.service.cancel_api.payload.client.CancelRequest;
import com.travelbeta.jactravel.service.cancel_api.payload.client.CancelResponse;
import com.travelbeta.jactravel.service.cancel_api.service.CancelRestService;
import com.travelbeta.jactravel.service.cancel_api.util.CancelMapperUtil;
import com.travelbeta.jactravel.service.config.TravelBetaConfig;
import com.travelbeta.jactravel.service.exception.JacTravelAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.travelbeta.jactravel.service.exception.ErrorMsg.INTERNAL_ERROR_TYPE;


/**
 * @author Brume
 **/

@Slf4j
@Service
public class CancelFacade {
    private final TravelBetaConfig travelBetaConfig;

    private final CancelRestService cancelRestService;

    private final CancelMapperUtil cancelMapperUtil;

    private final RedisTemplate<String, CancelResponse> redisTemplate;

    @Autowired
    public CancelFacade(TravelBetaConfig travelBetaConfig, CancelRestService cancelRestService, CancelMapperUtil cancelMapperUtil, RedisTemplate<String, CancelResponse> redisTemplate) {
        this.travelBetaConfig = travelBetaConfig;
        this.cancelRestService = cancelRestService;
        this.cancelMapperUtil = cancelMapperUtil;
        this.redisTemplate = redisTemplate;
    }


    private CancelResponse cancelJacTravels(CancelRequest cancelRequest) {

        val cancelHotelRequest = cancelMapperUtil.mapCancelHotelRequest.apply(cancelRequest);

        val cancelHotelResponse = cancelRestService.handleCancelHotel(cancelHotelRequest);

        if (cancelHotelResponse == null) {
            return null;
        }
        if (!cancelHotelResponse.getReturnStatus().isSuccess()) {
            log.info("Exception ::: {}", cancelHotelResponse.getReturnStatus().getException());
            throw new JacTravelAPIException(INTERNAL_ERROR_TYPE, cancelHotelResponse.getReturnStatus().getException());
        }
        return cancelMapperUtil.mapCancelResponse.apply(cancelHotelResponse);
    }

    public CancelResponse handleCancel(CancelRequest cancelRequest) {
        val redisKey = buildCancelRequestKey(cancelRequest);
        log.info("Query Key :::: {}", redisKey);
        val isKeyAvailable = redisTemplate.hasKey(redisKey);
        CancelResponse cancelResponse;
        if (isKeyAvailable) {
            log.info("============= Key Found in Redis Cache =========");
            return checkRedisCache(redisKey);
        } else {
            log.info("============= Key Not Found Checking API =========");
            cancelResponse = cancelJacTravels(cancelRequest);

            if (cancelResponse != null) {
                log.info("============= Updating Redis Cache with Key =========");
                val valueOperations = redisTemplate.opsForValue();
                valueOperations.set(redisKey, cancelResponse, travelBetaConfig.getCacheExpiryHours(), TimeUnit.HOURS);

                return cancelResponse;
            }
        }
        throw new JacTravelAPIException(INTERNAL_ERROR_TYPE, "Record Not Found");
    }


    private CancelResponse checkRedisCache(String redisKey) {
        val valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(redisKey);
    }

    private String buildCancelRequestKey(CancelRequest cancelRequest) {
        val stringBuilder = new StringBuilder();
        return stringBuilder.
                append(cancelRequest.getBookingReference())
                .append(cancelRequest.getCancellationCost())

                .toString();
    }
}
