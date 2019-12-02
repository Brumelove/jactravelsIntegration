package org.javasoft.searchapi.util;

import lombok.val;
import org.javasoft.searchapi.config.TravelBetaConfig;
import org.javasoft.searchapi.entity.HotelEntity;
import org.javasoft.searchapi.payload.client.SearchRequest;
import org.javasoft.searchapi.payload.client.SearchResponse;
import org.javasoft.searchapi.payload.travelbeta.request.LoginDetails;
import org.javasoft.searchapi.payload.travelbeta.request.SearchDetails;
import org.javasoft.searchapi.payload.travelbeta.request.SearchHotelRequest;
import org.javasoft.searchapi.payload.travelbeta.response.PropertyResult;
import org.javasoft.searchapi.payload.travelbeta.response.SearchHotelResponse;
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
