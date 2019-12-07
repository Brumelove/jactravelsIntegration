package org.javasoft.searchapi.precancel_api.facade;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.javasoft.searchapi.config.TravelBetaConfig;
import org.javasoft.searchapi.exception.SearchAPIException;
import org.javasoft.searchapi.precancel_api.payload.client.PreCancelRequest;
import org.javasoft.searchapi.precancel_api.payload.client.PreCancelResponse;
import org.javasoft.searchapi.precancel_api.service.PreCancelRestService;
import org.javasoft.searchapi.precancel_api.util.PreCancelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static org.javasoft.searchapi.exception.ErrorMsg.INTERNAL_ERROR_TYPE;


/**
 * @author Brume
 **/

@Slf4j
@Service
public class PreCancelFacade {
    private final TravelBetaConfig travelBetaConfig;

    private final PreCancelRestService preCancelRestService;

    private final PreCancelMapperUtil preCancelMapperUtil;

    private final RedisTemplate<String, PreCancelResponse> redisTemplate;

    @Autowired
    public PreCancelFacade(TravelBetaConfig travelBetaConfig, PreCancelRestService preCancelRestService, PreCancelMapperUtil preCancelMapperUtil, RedisTemplate<String, PreCancelResponse> redisTemplate) {
        this.travelBetaConfig = travelBetaConfig;
        this.preCancelRestService = preCancelRestService;
        this.preCancelMapperUtil = preCancelMapperUtil;
        this.redisTemplate = redisTemplate;
    }




    private PreCancelResponse preCancelJacTravels(PreCancelRequest preCancelRequest) {

        val preCancelHotelRequest = preCancelMapperUtil.mapPreCancelHotelRequest.apply(preCancelRequest);

        val preCancelHotelResponse = preCancelRestService.handlePreCancelHotel(preCancelHotelRequest);

        if (preCancelHotelResponse == null) {
            return null;
        }
        if (!preCancelHotelResponse.getReturnStatus().isSuccess()) {
            log.info("Exception ::: {}", preCancelHotelResponse.getReturnStatus().getException());
            throw new SearchAPIException(INTERNAL_ERROR_TYPE, preCancelHotelResponse.getReturnStatus().getException());
        }
        return preCancelMapperUtil.mapPreCancelResponse.apply(preCancelHotelResponse);
    }

    public PreCancelResponse handlePreCancel(PreCancelRequest preCancelRequest) {
        val redisKey = buildPreCancelRequestKey(preCancelRequest);
        log.info("Query Key :::: {}", redisKey);
        val isKeyAvailable = redisTemplate.hasKey(redisKey);
        PreCancelResponse preCancelResponse;
        if (isKeyAvailable) {
            log.info("============= Key Found in Redis Cache =========");
            return checkRedisCache(redisKey);
        } else {
            log.info("============= Key Not Found Checking API =========");
            preCancelResponse = preCancelJacTravels(preCancelRequest);

            if (preCancelResponse != null) {
                log.info("============= Updating Redis Cache with Key =========");
                val valueOperations = redisTemplate.opsForValue();
                valueOperations.set(redisKey, preCancelResponse, travelBetaConfig.getCacheExpiryHours(), TimeUnit.HOURS);

                return preCancelResponse;
            }
        }
        throw new SearchAPIException(INTERNAL_ERROR_TYPE, "Record Not Found");
    }


    private PreCancelResponse checkRedisCache(String redisKey) {
        val valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(redisKey);
    }

    private String buildPreCancelRequestKey(PreCancelRequest preCancelRequest) {
        val stringBuilder = new StringBuilder();
        return stringBuilder.append(
                preCancelRequest.getBookingReference())
                                .toString();
    }
}
