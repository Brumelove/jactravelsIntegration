package org.javasoft.searchapi.property_details_api.facade;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.javasoft.searchapi.config.TravelBetaConfig;
import org.javasoft.searchapi.exception.SearchAPIException;
import org.javasoft.searchapi.property_details_api.payload.client.PropertyDetailsRequest;
import org.javasoft.searchapi.property_details_api.payload.client.PropertyDetailsResponse;
import org.javasoft.searchapi.property_details_api.service.MultiBookSearchRestService;
import org.javasoft.searchapi.property_details_api.util.MultiBookSearchMapperUtil;
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

    private final MultiBookSearchRestService multiBookSearchRestService;

    private final MultiBookSearchMapperUtil multiBookSearchMapperUtil;

    private final RedisTemplate<String, PropertyDetailsResponse> redisTemplate;

    @Autowired
    public PropertyDetailsFacade(TravelBetaConfig travelBetaConfig, MultiBookSearchRestService multiBookSearchRestService, MultiBookSearchMapperUtil multiBookSearchMapperUtil, RedisTemplate<String, PropertyDetailsResponse> redisTemplate) {
        this.travelBetaConfig = travelBetaConfig;
        this.multiBookSearchRestService = multiBookSearchRestService;
        this.multiBookSearchMapperUtil = multiBookSearchMapperUtil;
        this.redisTemplate = redisTemplate;
    }


    private PropertyDetailsResponse MultiBookSearchJacTravels(PropertyDetailsRequest propertyDetailsRequest) {

        val multiBookSearchHotelRequest = multiBookSearchMapperUtil.mapMultiBookSearchHotelRequest.apply(propertyDetailsRequest);

        val multiBookSearchHotelResponse = multiBookSearchRestService.handleMultiBookSearchHotel(multiBookSearchHotelRequest);

        if (multiBookSearchHotelResponse == null) {
            return null;
        }
        if (!multiBookSearchHotelResponse.getReturnStatus().isSuccess()) {
            log.info("Exception ::: {}", multiBookSearchHotelResponse.getReturnStatus().getException());
            throw new SearchAPIException(INTERNAL_ERROR_TYPE, multiBookSearchHotelResponse.getReturnStatus().getException());
        }
        return multiBookSearchMapperUtil.mapPreCancelResponse.apply(multiBookSearchHotelResponse);
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
        throw new SearchAPIException(INTERNAL_ERROR_TYPE, "Record Not Found");
    }


    private PropertyDetailsResponse checkRedisCache(String redisKey) {
        val valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(redisKey);
    }

    private String buildPreCancelRequestKey(PropertyDetailsRequest propertyDetailsRequest) {
        val stringBuilder = new StringBuilder();
        return stringBuilder.append(
                propertyDetailsRequest.getBookingCreationEndDate())
                .append(propertyDetailsRequest.getBookingCreationStartDate())
                .toString();
    }
}
