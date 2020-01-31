package com.travelbeta.jactravels.service.book_search_api.facade;

import com.travelbeta.jactravels.service.book_search_api.util.BookSearchMapperUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import com.travelbeta.jactravels.service.config.TravelBetaConfig;
import com.travelbeta.jactravels.service.exception.JacTravelAPIException;
import com.travelbeta.jactravels.service.book_search_api.payload.client.BookSearchRequest;
import com.travelbeta.jactravels.service.book_search_api.payload.client.BookSearchResponse;
import com.travelbeta.jactravels.service.book_search_api.service.BookSearchRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.travelbeta.jactravels.service.exception.ErrorMsg.INTERNAL_ERROR_TYPE;


/**
 * @author Brume
 **/

@Slf4j
@Service
public class BookSearchFacade {
    private final TravelBetaConfig travelBetaConfig;

    private final BookSearchRestService bookSearchRestService;

    private final BookSearchMapperUtil bookSearchMapperUtil;

    private final RedisTemplate<String, BookSearchResponse> redisTemplate;

    @Autowired
    public BookSearchFacade(TravelBetaConfig travelBetaConfig, BookSearchRestService bookSearchRestService, BookSearchMapperUtil bookSearchMapperUtil, RedisTemplate<String, BookSearchResponse> redisTemplate) {
        this.travelBetaConfig = travelBetaConfig;
        this.bookSearchRestService = bookSearchRestService;
        this.bookSearchMapperUtil = bookSearchMapperUtil;
        this.redisTemplate = redisTemplate;
    }


    private BookSearchResponse BookSearchJacTravels(BookSearchRequest bookSearchRequest) {

        val bookSearchHotelRequest = bookSearchMapperUtil.mapBookSearchHotelRequest.apply(bookSearchRequest);

        val bookSearchHotelResponse = bookSearchRestService.handleBookSearchHotel(bookSearchHotelRequest);

        if (bookSearchHotelResponse == null) {
            return null;
        }
        if (!bookSearchHotelResponse.getReturnStatus().isSuccess()) {
            log.info("Exception ::: {}", bookSearchHotelResponse.getReturnStatus().getException());
            throw new JacTravelAPIException(INTERNAL_ERROR_TYPE, bookSearchHotelResponse.getReturnStatus().getException());
        }
        return bookSearchMapperUtil.mapBookSearchResponse.apply(bookSearchHotelResponse);
    }

    public BookSearchResponse handleBookSearch(BookSearchRequest bookSearchRequest) {
        val redisKey = buildBookSearchRequestKey(bookSearchRequest);
        log.info("Query Key :::: {}", redisKey);
        val isKeyAvailable = redisTemplate.hasKey(redisKey);
        BookSearchResponse bookSearchResponse;
        if (isKeyAvailable) {
            log.info("============= Key Found in Redis Cache =========");
            return checkRedisCache(redisKey);
        } else {
            log.info("============= Key Not Found Checking API =========");
            bookSearchResponse = BookSearchJacTravels(bookSearchRequest);

            if (bookSearchResponse != null) {
                log.info("============= Updating Redis Cache with Key =========");
                val valueOperations = redisTemplate.opsForValue();
                valueOperations.set(redisKey, bookSearchResponse, travelBetaConfig.getCacheExpiryHours(), TimeUnit.MINUTES);

                return bookSearchResponse;
            }
        }
        throw new JacTravelAPIException(INTERNAL_ERROR_TYPE, "Record Not Found");
    }


    private BookSearchResponse checkRedisCache(String redisKey) {
        val valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(redisKey);
    }

    private String buildBookSearchRequestKey(BookSearchRequest bookSearchRequest) {
        val stringBuilder = new StringBuilder();
        return stringBuilder.append(
                bookSearchRequest.getBookingReference())
                .append(2)
                .toString();
    }
}
