package org.javasoft.searchapi.multi_book_search_api.facade;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.javasoft.searchapi.config.TravelBetaConfig;
import org.javasoft.searchapi.exception.JacTravelAPIException;
import org.javasoft.searchapi.multi_book_search_api.payload.client.MultiBookSearchRequest;
import org.javasoft.searchapi.multi_book_search_api.payload.client.MultiBookSearchResponse;
import org.javasoft.searchapi.multi_book_search_api.service.MultiBookSearchRestService;
import org.javasoft.searchapi.multi_book_search_api.util.MultiBookSearchMapperUtil;
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
public class MultiBookSearchFacade {
    private final TravelBetaConfig travelBetaConfig;

    private final MultiBookSearchRestService multiBookSearchRestService;

    private final MultiBookSearchMapperUtil multiBookSearchMapperUtil;

    private final RedisTemplate<String, MultiBookSearchResponse> redisTemplate;

    @Autowired
    public MultiBookSearchFacade(TravelBetaConfig travelBetaConfig, MultiBookSearchRestService multiBookSearchRestService, MultiBookSearchMapperUtil multiBookSearchMapperUtil, RedisTemplate<String, MultiBookSearchResponse> redisTemplate) {
        this.travelBetaConfig = travelBetaConfig;
        this.multiBookSearchRestService = multiBookSearchRestService;
        this.multiBookSearchMapperUtil = multiBookSearchMapperUtil;
        this.redisTemplate = redisTemplate;
    }


    private MultiBookSearchResponse MultiBookSearchJacTravels(MultiBookSearchRequest multiBookSearchRequest) {

        val multiBookSearchHotelRequest = multiBookSearchMapperUtil.mapMultiBookSearchHotelRequest.apply(multiBookSearchRequest);

        val multiBookSearchHotelResponse = multiBookSearchRestService.handleMultiBookSearchHotel(multiBookSearchHotelRequest);

        if (multiBookSearchHotelResponse == null) {
            return null;
        }
        if (!multiBookSearchHotelResponse.getReturnStatus().isSuccess()) {
            log.info("Exception ::: {}", multiBookSearchHotelResponse.getReturnStatus().getException());
            throw new JacTravelAPIException(INTERNAL_ERROR_TYPE, multiBookSearchHotelResponse.getReturnStatus().getException());
        }
        return multiBookSearchMapperUtil.mapPreCancelResponse.apply(multiBookSearchHotelResponse);
    }

    public MultiBookSearchResponse handleMultiBookSearch(MultiBookSearchRequest multiBookSearchRequest) {
        val redisKey = buildPreCancelRequestKey(multiBookSearchRequest);
        log.info("Query Key :::: {}", redisKey);
        val isKeyAvailable = redisTemplate.hasKey(redisKey);
        MultiBookSearchResponse multiBookSearchResponse;
        if (isKeyAvailable) {
            log.info("============= Key Found in Redis Cache =========");
            return checkRedisCache(redisKey);
        } else {
            log.info("============= Key Not Found Checking API =========");
            multiBookSearchResponse = MultiBookSearchJacTravels(multiBookSearchRequest);

            if (multiBookSearchResponse != null) {
                log.info("============= Updating Redis Cache with Key =========");
                val valueOperations = redisTemplate.opsForValue();
                valueOperations.set(redisKey, multiBookSearchResponse, travelBetaConfig.getCacheExpiryHours(), TimeUnit.HOURS);

                return multiBookSearchResponse;
            }
        }
        throw new JacTravelAPIException(INTERNAL_ERROR_TYPE, "Record Not Found");
    }


    private MultiBookSearchResponse checkRedisCache(String redisKey) {
        val valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(redisKey);
    }

    private String buildPreCancelRequestKey(MultiBookSearchRequest multiBookSearchRequest) {
        val stringBuilder = new StringBuilder();
        return stringBuilder.append(
                multiBookSearchRequest.getBookingCreationEndDate())
                .append(multiBookSearchRequest.getBookingCreationStartDate())
                .toString();
    }
}
