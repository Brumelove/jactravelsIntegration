package com.travelbeta.jactravels.service.multi_book_search_api.util;


import lombok.val;
import com.travelbeta.jactravels.service.config.TravelBetaConfig;
import com.travelbeta.jactravels.service.multi_book_search_api.payload.client.MultiBookSearchRequest;
import com.travelbeta.jactravels.service.multi_book_search_api.payload.client.MultiBookSearchResponse;
import com.travelbeta.jactravels.service.multi_book_search_api.payload.jactravel.request.MultiBookSearchHotelRequest;
import com.travelbeta.jactravels.service.multi_book_search_api.payload.jactravel.response.MultiBookSearchHotelResponse;
import com.travelbeta.jactravels.service.search_api.payload.travelbeta.request.LoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author Brume
 **/
@Component
public class MultiBookSearchMapperUtil {
    private TravelBetaConfig travelBetaConfig;

    @Autowired
    public MultiBookSearchMapperUtil(TravelBetaConfig travelBetaConfig) {
        this.travelBetaConfig = travelBetaConfig;
    }


    public Function<MultiBookSearchHotelResponse, MultiBookSearchResponse> mapMultiBookSearchResponse = multiBookSearchHotelResponse -> {
        val multiBookSearchResponse = new MultiBookSearchResponse();
        multiBookSearchResponse.setReturnStatus(multiBookSearchHotelResponse.getReturnStatus());
        multiBookSearchResponse.setBookings(multiBookSearchHotelResponse.getBookings());

        return multiBookSearchResponse;
    };

    public Function<MultiBookSearchRequest, MultiBookSearchHotelRequest> mapMultiBookSearchHotelRequest = multiBookSearchRequest -> {
        val multiBookSearchHotelRequest = new MultiBookSearchHotelRequest();

        val loginDetails = getLoginDetails();

        multiBookSearchHotelRequest.setLoginDetails(loginDetails);
        multiBookSearchHotelRequest.setBookingCreationEndDate(multiBookSearchRequest.getBookingCreationEndDate());
        multiBookSearchHotelRequest.setBookingCreationStartDate(multiBookSearchRequest.getBookingCreationStartDate());
        multiBookSearchHotelRequest.setAllComponents(multiBookSearchRequest.isAllComponents());

        return multiBookSearchHotelRequest;
    };

    private LoginDetails getLoginDetails() {
        val loginDetails = new LoginDetails();
        loginDetails.setAgentReference("");
        loginDetails.setCurrencyID(2);
        loginDetails.setLocale("");
        loginDetails.setLogin(travelBetaConfig.getUsername());
        loginDetails.setPassword(travelBetaConfig.getPassword());
        return loginDetails;
    }

}
