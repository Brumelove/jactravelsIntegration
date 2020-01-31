package com.travelbeta.jactravels.service.search_api.util;

import com.travelbeta.jactravels.service.search_api.payload.travelbeta.request.LoginDetails;
import com.travelbeta.jactravels.service.search_api.payload.travelbeta.request.SearchDetails;
import com.travelbeta.jactravels.service.search_api.payload.travelbeta.request.SearchHotelRequest;
import com.travelbeta.jactravels.service.search_api.payload.travelbeta.response.PropertyResult;
import com.travelbeta.jactravels.service.search_api.payload.travelbeta.response.SearchHotelResponse;
import lombok.val;
import com.travelbeta.jactravels.service.config.TravelBetaConfig;
import com.travelbeta.jactravels.service.search_api.entity.HotelEntity;
import com.travelbeta.jactravels.service.search_api.payload.client.SearchRequest;
import com.travelbeta.jactravels.service.search_api.payload.client.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtil {

    private TravelBetaConfig travelBetaConfig;

    @Autowired
    public MapperUtil(TravelBetaConfig travelBetaConfig) {
        this.travelBetaConfig = travelBetaConfig;
    }

    public Function<HotelEntity , PropertyResult> mapPropertyResult = hotelEntity -> {
        val propertyResult = new PropertyResult();
        propertyResult.setRating(String.valueOf(hotelEntity.getRating()));
        propertyResult.setPropertyName(hotelEntity.getName());
        return propertyResult;
    };

    public Function<SearchHotelResponse, SearchResponse> mapSearchResponse = searchHotelResponse -> {
        val searchResponse = new SearchResponse();
        searchResponse.setCurrencyID(searchHotelResponse.getCurrencyID());
        searchResponse.setPropertyResults(searchHotelResponse.getPropertyResults());
        return searchResponse;
    };

    public Function<SearchRequest , SearchHotelRequest> mapSearchHotelRequest = searchRequest -> {
        val searchHotelRequest = new SearchHotelRequest();

        val loginDetails = new LoginDetails();
        loginDetails.setAgentReference("");
        loginDetails.setCurrencyID(2);
        loginDetails.setLocale("");
        loginDetails.setLogin(travelBetaConfig.getUsername());
        loginDetails.setPassword(travelBetaConfig.getPassword());

        val searchDetails = new SearchDetails();
        searchDetails.setCheckInDate(searchRequest.getCheckInDate());
        searchDetails.setDuration(searchRequest.getDuration());
        searchDetails.setMealBasisID(searchRequest.getMealBasisID());
        searchDetails.setMinStarRating(searchRequest.getMinStarRating());
        searchDetails.setRegionID(searchRequest.getRegionID());
        searchDetails.setRoomInfoList(searchRequest.getRoomInfoList());

        searchHotelRequest.setLoginDetails(loginDetails);
        searchHotelRequest.setSearchDetails(searchDetails);

        return searchHotelRequest;
    };


}
