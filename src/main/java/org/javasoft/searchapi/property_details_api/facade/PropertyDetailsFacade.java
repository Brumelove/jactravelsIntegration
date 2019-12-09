package org.javasoft.searchapi.property_details_api.facade;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.javasoft.searchapi.config.TravelBetaConfig;
import org.javasoft.searchapi.exception.JacTravelAPIException;
import org.javasoft.searchapi.property_details_api.payload.client.PropertyDetailsRequest;
import org.javasoft.searchapi.property_details_api.payload.client.PropertyDetailsResponse;
import org.javasoft.searchapi.property_details_api.service.PropertyDetailsRestService;
import org.javasoft.searchapi.property_details_api.util.PropertyDetailsMapperUtil;
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
public class PropertyDetailsFacade {
    private final TravelBetaConfig travelBetaConfig;

    private final PropertyDetailsRestService propertyDetailsRestService;

    private final PropertyDetailsMapperUtil propertyDetailsMapperUtil;

    private final RedisTemplate<String, PropertyDetailsResponse> redisTemplate;

    @Autowired
    public PropertyDetailsFacade(TravelBetaConfig travelBetaConfig, PropertyDetailsRestService propertyDetailsRestService, PropertyDetailsMapperUtil propertyDetailsMapperUtil, RedisTemplate<String, PropertyDetailsResponse> redisTemplate) {
        this.travelBetaConfig = travelBetaConfig;
        this.propertyDetailsRestService = propertyDetailsRestService;
        this.propertyDetailsMapperUtil = propertyDetailsMapperUtil;
        this.redisTemplate = redisTemplate;
    }


    private PropertyDetailsResponse MultiBookSearchJacTravels(PropertyDetailsRequest propertyDetailsRequest) {

        val propertyDetailsHotelRequest = propertyDetailsMapperUtil.mapPropertyDetailsHotelRequest.apply(propertyDetailsRequest);

        val propertyDetailsHotelResponse = propertyDetailsRestService.handlePropertyDetailsHotel(propertyDetailsHotelRequest);

        if (propertyDetailsHotelResponse == null) {
            return null;
        }
        if (!propertyDetailsHotelResponse.getReturnStatus().isSuccess()) {
            log.info("Exception ::: {}", propertyDetailsHotelResponse.getReturnStatus().getException());
            throw new JacTravelAPIException(INTERNAL_ERROR_TYPE, propertyDetailsHotelResponse.getReturnStatus().getException());
        }
        return propertyDetailsMapperUtil.mapPropertyDetailsResponse.apply(propertyDetailsHotelResponse);
    }

    public PropertyDetailsResponse handleMultiBookSearch(PropertyDetailsRequest propertyDetailsRequest) {
        val redisKey = buildPreCancelRequestKey(propertyDetailsRequest);
        log.info("Query Key :::: {}", redisKey);
        val isKeyAvailable = redisTemplate.hasKey(redisKey);
        PropertyDetailsResponse propertyDetailsResponse;
        if (isKeyAvailable) {
            log.info("============= Key Found in Redis Cache =========");
            return checkRedisCache(redisKey);
        } else {
            log.info("============= Key Not Found Checking API =========");
            propertyDetailsResponse = MultiBookSearchJacTravels(propertyDetailsRequest);

            if (propertyDetailsResponse != null) {
                log.info("============= Updating Redis Cache with Key =========");
                val valueOperations = redisTemplate.opsForValue();
                valueOperations.set(redisKey, propertyDetailsResponse, travelBetaConfig.getCacheExpiryHours(), TimeUnit.HOURS);

                return propertyDetailsResponse;
            }
        }
        throw new JacTravelAPIException(INTERNAL_ERROR_TYPE, "Record Not Found");
    }


    private PropertyDetailsResponse checkRedisCache(String redisKey) {
        val valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(redisKey);
    }

    private String buildPreCancelRequestKey(PropertyDetailsRequest propertyDetailsRequest) {
        val stringBuilder = new StringBuilder();
        return stringBuilder.append(
                propertyDetailsRequest.getPropertyID())
                .append(propertyDetailsRequest.getPropertyReferenceID())
                .toString();
    }
}
