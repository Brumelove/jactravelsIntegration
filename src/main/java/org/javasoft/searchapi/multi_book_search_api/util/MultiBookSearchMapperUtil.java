package org.javasoft.searchapi.multi_book_search_api.util;


import lombok.val;
import org.javasoft.searchapi.config.TravelBetaConfig;
import org.javasoft.searchapi.multi_book_search_api.payload.client.MultiBookSearchRequest;
import org.javasoft.searchapi.multi_book_search_api.payload.client.MultiBookSearchResponse;
import org.javasoft.searchapi.multi_book_search_api.payload.jactravel.request.MultiBookSearchHotelRequest;
import org.javasoft.searchapi.multi_book_search_api.payload.jactravel.response.Booking;
import org.javasoft.searchapi.multi_book_search_api.payload.jactravel.response.MultiBookSearchHotelResponse;
import org.javasoft.searchapi.payload.travelbeta.request.LoginDetails;
import org.javasoft.searchapi.payload.travelbeta.request.RoomInfo;
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


    public Function<MultiBookSearchHotelResponse, MultiBookSearchResponse> mapPreCancelResponse = multiBookSearchHotelResponse -> {
        val multiBookSearchResponse = new MultiBookSearchResponse();
        multiBookSearchHotelResponse.setReturnStatus(multiBookSearchHotelResponse.getReturnStatus());
        multiBookSearchHotelResponse.setBookings(multiBookSearchHotelResponse.getBookings());

        return multiBookSearchResponse;
    };

    public Function<MultiBookSearchRequest, MultiBookSearchHotelRequest> mapMultiBookSearchHotelRequest = multiBookSearchRequest -> {
        val preCancelHotelRequest = new MultiBookSearchHotelRequest();

        val loginDetails = getLoginDetails();

        preCancelHotelRequest.setLoginDetails(loginDetails);


        return preCancelHotelRequest;
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
