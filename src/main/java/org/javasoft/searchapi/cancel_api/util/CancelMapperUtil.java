package org.javasoft.searchapi.cancel_api.util;


import lombok.val;
import org.javasoft.searchapi.cancel_api.payload.client.CancelRequest;
import org.javasoft.searchapi.cancel_api.payload.client.CancelResponse;
import org.javasoft.searchapi.cancel_api.payload.jactravel.request.CancelHotelRequest;
import org.javasoft.searchapi.cancel_api.payload.jactravel.response.CancelHotelResponse;
import org.javasoft.searchapi.config.TravelBetaConfig;
import org.javasoft.searchapi.payload.travelbeta.request.LoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author Brume
 **/
@Component
public class CancelMapperUtil {
    private TravelBetaConfig travelBetaConfig;

    @Autowired
    public CancelMapperUtil(TravelBetaConfig travelBetaConfig) {
        this.travelBetaConfig = travelBetaConfig;
    }


    public Function<CancelHotelResponse, CancelResponse> mapCancelResponse = cancelHotelResponse -> {
        val cancelResponse = new CancelResponse();

        cancelHotelResponse.setReturnStatus(cancelHotelResponse.getReturnStatus());
        return cancelResponse;
    };

    public Function<CancelRequest, CancelHotelRequest> mapCancelHotelRequest = cancelRequest -> {
        val cancelHotelRequest = new CancelHotelRequest();

        val loginDetails = getLoginDetails();

//        val bookingDetails = new PreCancelDetails();
//
        cancelHotelRequest.setLoginDetails(loginDetails);
//        cancelHotelRequest.setPreCancelDetails(bookingDetails);

        return cancelHotelRequest;
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
