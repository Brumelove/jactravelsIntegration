package com.travelbeta.jacktravels.service.cancel_api.util;


import lombok.val;
import com.travelbeta.jacktravels.service.cancel_api.payload.client.CancelRequest;
import com.travelbeta.jacktravels.service.cancel_api.payload.client.CancelResponse;
import com.travelbeta.jacktravels.service.cancel_api.payload.jactravel.request.CancelHotelRequest;
import com.travelbeta.jacktravels.service.cancel_api.payload.jactravel.response.CancelHotelResponse;
import com.travelbeta.jacktravels.service.config.TravelBetaConfig;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.request.LoginDetails;
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
        cancelResponse.setReturnStatus(cancelHotelResponse.getReturnStatus());
        return cancelResponse;
    };

    public Function<CancelRequest, CancelHotelRequest> mapCancelHotelRequest = cancelRequest -> {
        val cancelHotelRequest = new CancelHotelRequest();

        val loginDetails = getLoginDetails();

        cancelHotelRequest.setLoginDetails(loginDetails);
        cancelHotelRequest.setBookingReference(cancelRequest.getBookingReference());
        cancelHotelRequest.setCancellationCost(cancelRequest.getCancellationCost());
        cancelHotelRequest.setCancellationToken(cancelRequest.getCancellationToken());

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
