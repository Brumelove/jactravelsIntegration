package org.javasoft.searchapi.precancel_api.util;


import lombok.val;
import org.javasoft.searchapi.config.TravelBetaConfig;
import org.javasoft.searchapi.payload.travelbeta.request.LoginDetails;
import org.javasoft.searchapi.precancel_api.payload.client.PreCancelRequest;
import org.javasoft.searchapi.precancel_api.payload.client.PreCancelResponse;
import org.javasoft.searchapi.precancel_api.payload.jactravel.request.PreCancelHotelRequest;
import org.javasoft.searchapi.precancel_api.payload.jactravel.response.PreCancelHotelResponse;
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
        preCancelResponse.setReturnStatus(preCancelHotelResponse.getReturnStatus());
        preCancelResponse.setBookingReference(preCancelHotelResponse.getBookingReference());
        preCancelResponse.setCancellationCost(preCancelHotelResponse.getCancellationCost());
        preCancelResponse.setCancellationToken(preCancelHotelResponse.getCancellationToken());

        return preCancelResponse;
    };

    public Function<PreCancelRequest, PreCancelHotelRequest> mapPreCancelHotelRequest = preCancelRequest -> {
        val preCancelHotelRequest = new PreCancelHotelRequest();
        preCancelHotelRequest.setBookingReference(preCancelRequest.getBookingReference());

        val loginDetails = getLoginDetails();

        preCancelHotelRequest.setLoginDetails(loginDetails);
        preCancelHotelRequest.setBookingReference(preCancelRequest.getBookingReference());

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
