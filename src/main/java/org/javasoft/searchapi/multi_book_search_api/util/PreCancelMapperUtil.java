package org.javasoft.searchapi.multi_book_search_api.util;


import lombok.val;
import org.javasoft.searchapi.config.TravelBetaConfig;
import org.javasoft.searchapi.multi_book_search_api.payload.client.PreCancelRequest;
import org.javasoft.searchapi.multi_book_search_api.payload.client.PreCancelResponse;
import org.javasoft.searchapi.multi_book_search_api.payload.jactravel.request.PreCancelHotelRequest;
import org.javasoft.searchapi.multi_book_search_api.payload.jactravel.response.PreCancelHotelResponse;
import org.javasoft.searchapi.payload.travelbeta.request.LoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author Brume
 **/
@Component
public class PreCancelMapperUtil {
    private TravelBetaConfig travelBetaConfig;

    @Autowired
    public PreCancelMapperUtil(TravelBetaConfig travelBetaConfig) {
        this.travelBetaConfig = travelBetaConfig;
    }


    public Function<PreCancelHotelResponse, PreCancelResponse> mapPreCancelResponse = preCancelHotelResponse -> {
        val preCancelResponse = new PreCancelResponse();
        preCancelResponse.setCurrencyID(preCancelResponse.getCurrencyID());
        preCancelHotelResponse.setReturnStatus(preCancelHotelResponse.getReturnStatus());
        preCancelResponse.setBookingReference(preCancelHotelResponse.getBookingReference());
        preCancelResponse.setCancellationCost(preCancelHotelResponse.getCancellationCost());
        preCancelResponse.setCancellationToken(preCancelHotelResponse.getCancellationToken());

        return preCancelResponse;
    };

    public Function<PreCancelRequest, PreCancelHotelRequest> mapPreCancelHotelRequest = preCancelRequest -> {
        val preCancelHotelRequest = new PreCancelHotelRequest();

        val loginDetails = getLoginDetails();

//        val bookingDetails = new PreCancelDetails();
//
      preCancelHotelRequest.setLoginDetails(loginDetails);
//        preCancelHotelRequest.setPreCancelDetails(bookingDetails);

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
