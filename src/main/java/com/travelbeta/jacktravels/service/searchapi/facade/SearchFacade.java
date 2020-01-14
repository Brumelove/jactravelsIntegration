package com.travelbeta.jacktravels.service.searchapi.facade;

import com.travelbeta.jacktravels.service.searchapi.service.db.LocationDbService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import com.travelbeta.jacktravels.service.config.TravelBetaConfig;
import com.travelbeta.jacktravels.service.exception.JacTravelAPIException;
import com.travelbeta.jacktravels.service.searchapi.payload.client.SearchRequest;
import com.travelbeta.jacktravels.service.searchapi.payload.client.SearchResponse;
import com.travelbeta.jacktravels.service.searchapi.service.db.HotelDbService;
import com.travelbeta.jacktravels.service.searchapi.service.rest.TravelBetaRestService;
import com.travelbeta.jacktravels.service.searchapi.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.travelbeta.jacktravels.service.exception.ErrorMsg.INTERNAL_ERROR_TYPE;

@Slf4j
@Service
public class SearchFacade {

    private final TravelBetaConfig travelBetaConfig;

    private final TravelBetaRestService travelBetaRestService;

    private final MapperUtil mapperUtil;

    @Autowired
    private HotelDbService hotelDbService;
    private LocationDbService locationDbService;

    private final RedisTemplate<String, SearchResponse> redisTemplate;

    @Autowired
    public SearchFacade(TravelBetaConfig travelBetaConfig, TravelBetaRestService travelBetaRestService, MapperUtil mapperUtil,
                        RedisTemplate<String, SearchResponse> redisTemplate) {
        this.travelBetaConfig = travelBetaConfig;
        this.travelBetaRestService = travelBetaRestService;
        this.mapperUtil = mapperUtil;
        this.redisTemplate = redisTemplate;
    }

    //first check cache
    //then check db
    //then check api
    //return 404 if not found
    public SearchResponse handleSearch(SearchRequest searchRequest) {
        val redisKey = buildSearchRequestKey(searchRequest);
        log.info("Query Key :::: {}", redisKey);
        val isKeyAvailable = redisTemplate.hasKey(redisKey);

//        final CompletableFuture<SearchResponse> handleDb = CompletableFuture.supplyAsync(() -> handleSearchDb(searchRequest));
//        final CompletableFuture<SearchResponse> hnadleAPI = CompletableFuture.supplyAsync(() -> handleSearchAPI(searchRequest));
//
//        ExecutorService executor = Executors.newCachedThreadPool();
//        SearchResponse<Future<?>> = Stream.<Runnable>of(() ->  handleSearchDb(searchRequest), () -> handleSearchAPI(searchRequest))
//                .map(executor::submit)
//                .collect(Collectors.toList());
//        for (Future<?> future : futures) {
//            try {
//                future.get(); // do whatever you need here
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }

        SearchResponse searchResponse = null;

        if (isKeyAvailable) {
            log.info("============= Key Found in Redis Cache =========");
            return checkRedisCache(redisKey);
        } else {

            searchResponse = hotelDbService.findHotel(searchRequest);
            if (searchResponse == null) {
                log.info("============= Key Not Found in DB , Checking API =========");
                searchResponse = callTravelBetaAPI(searchRequest);
                //log.info("Search Response :::: {}", searchResponse.toString());
            }
            if (searchResponse != null) {
                log.info("============= Updating Redis Cache with Key =========");
                val valueOperations = redisTemplate.opsForValue();
                valueOperations.set(redisKey, searchResponse, travelBetaConfig.getCacheExpiryHours(), TimeUnit.MINUTES);

                return searchResponse;
            }
        }
        throw new JacTravelAPIException(INTERNAL_ERROR_TYPE, "Record Not Found");
    }
    public SearchResponse handleSearchDb(SearchRequest searchRequest) {
        SearchResponse searchResponse = hotelDbService.findHotel(searchRequest);

        return searchResponse;
    }
    public SearchResponse handleSearchAPI(SearchRequest searchRequest) {
        SearchResponse searchResponse = callTravelBetaAPI(searchRequest);

        return searchResponse;
    }

    public SearchResponse handleCountry(SearchRequest searchRequest) {
        SearchResponse countrySearchResponse = locationDbService.findLocationByCountry(searchRequest);

        return countrySearchResponse;
    }

    private SearchResponse callTravelBetaAPI(SearchRequest searchRequest) {
        val searchHotelRequest = mapperUtil.mapSearchHotelRequest.apply(searchRequest);
        val searchHotelResponse = travelBetaRestService.handleSearchHotel(searchHotelRequest);
        if (searchHotelResponse == null) {
            return null;
        }
        if (!searchHotelResponse.getReturnStatus().isSuccess()) {
            log.info("Exception ::: {}", searchHotelResponse.getReturnStatus().getException());
            throw new JacTravelAPIException(INTERNAL_ERROR_TYPE, searchHotelResponse.getReturnStatus().getException());
        }
        return mapperUtil.mapSearchResponse.apply(searchHotelResponse);
    }

    private SearchResponse checkRedisCache(String redisKey) {
        val valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(redisKey);
    }

    private String buildSearchRequestKey(SearchRequest searchRequest) {
        val stringBuilder = new StringBuilder();
        return stringBuilder.append(searchRequest.getCheckInDate())
                .append(searchRequest.getDuration())
                .append(searchRequest.getRegionID())
                .append(searchRequest.getMealBasisID())
                .append(searchRequest.getMinStarRating())
                .toString();
    }


}
