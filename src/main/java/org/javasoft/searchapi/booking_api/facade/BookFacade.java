package org.javasoft.searchapi.booking_api.facade;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.javasoft.searchapi.booking_api.payload.client.BookRequest;
import org.javasoft.searchapi.booking_api.payload.client.BookResponse;
import org.javasoft.searchapi.booking_api.service.BookingRestService;
import org.javasoft.searchapi.booking_api.util.BookMapperUtil;
import org.javasoft.searchapi.config.TravelBetaConfig;
import org.javasoft.searchapi.exception.SearchAPIException;
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
public class BookFacade {
    private final TravelBetaConfig travelBetaConfig;

    private final BookingRestService bookingRestService;

    private final BookMapperUtil bookMapperUtil;

    private final RedisTemplate<String, BookResponse> redisTemplate;

    @Autowired
    public BookFacade(TravelBetaConfig travelBetaConfig, BookingRestService bookingRestService, BookMapperUtil bookMapperUtil, RedisTemplate<String, BookResponse> redisTemplate) {
        this.travelBetaConfig = travelBetaConfig;
        this.bookingRestService = bookingRestService;
        this.bookMapperUtil = bookMapperUtil;
        this.redisTemplate = redisTemplate;
    }


    private BookResponse bookJacTravels(BookRequest bookRequest) {

        val bookHotelRequest = bookMapperUtil.mapBookHotelRequest.apply(bookRequest);

        val bookHotelResponse = bookingRestService.handleBookHotel(bookHotelRequest);

        if (bookHotelResponse == null) {
            return null;
        }
        if (!bookHotelResponse.getReturnStatus().isSuccess()) {
            log.info("Exception ::: {}", bookHotelResponse.getReturnStatus().getException());
            throw new SearchAPIException(INTERNAL_ERROR_TYPE, bookHotelResponse.getReturnStatus().getException());
        }
        return bookMapperUtil.mapBookResponse.apply(bookHotelResponse);
    }

    public BookResponse handlePreBook(BookRequest bookRequest) {
        val redisKey = buildBookRequestKey(bookRequest);
        log.info("Query Key :::: {}", redisKey);
        val isKeyAvailable = redisTemplate.hasKey(redisKey);
        BookResponse bookResponse;
        if (isKeyAvailable) {
            log.info("============= Key Found in Redis Cache =========");
            return checkRedisCache(redisKey);
        } else {
            log.info("=============  Checking API =========");
            bookResponse = bookJacTravels(bookRequest);

            if (bookResponse != null) {
                log.info("============= Updating Redis Cache with Key =========");
                val valueOperations = redisTemplate.opsForValue();
                valueOperations.set(redisKey, bookResponse, travelBetaConfig.getCacheExpiryHours(), TimeUnit.HOURS);

                return bookResponse;
            }
        }
        throw new SearchAPIException(INTERNAL_ERROR_TYPE, "Record Not Found");
    }


    private BookResponse checkRedisCache(String redisKey) {
        val valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(redisKey);
    }

    private String buildBookRequestKey(BookRequest bookRequest) {
        val stringBuilder = new StringBuilder();
        return stringBuilder.append(
                bookRequest.getArrivalDate())
                .append(bookRequest.getDuration())
                .append(bookRequest.getPropertyID())
                .append(bookRequest.getLeadGuestPhone())
                .toString();
    }
}
