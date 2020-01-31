package com.travelbeta.jactravels.service.prebooking_api.util;


import com.travelbeta.jactravels.service.config.TravelBetaConfig;
import com.travelbeta.jactravels.service.prebooking_api.payload.client.PreBookRequest;
import com.travelbeta.jactravels.service.prebooking_api.payload.client.PreBookResponse;
import com.travelbeta.jactravels.service.prebooking_api.payload.jactravel.request.PreBookHotelRequest;
import com.travelbeta.jactravels.service.prebooking_api.payload.jactravel.request.PreBookingDetails;
import com.travelbeta.jactravels.service.prebooking_api.payload.jactravel.response.PreBookHotelResponse;
import com.travelbeta.jactravels.service.search_api.payload.travelbeta.request.LoginDetails;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author Brume
 **/
@Component
public class PreBookMapperUtil {
    private TravelBetaConfig travelBetaConfig;

    @Autowired
    public PreBookMapperUtil(TravelBetaConfig travelBetaConfig) {
        this.travelBetaConfig = travelBetaConfig;
    }


    public Function<PreBookHotelResponse, PreBookResponse> mapPreBookRessponse = preBookHotelResponse -> {
        val preResponse = new PreBookResponse();
        preResponse.setCurrencyID(preBookHotelResponse.getCurrencyID());
        preResponse.setPreBookingToken(preBookHotelResponse.getPreBookingToken());
        preResponse.setReturnStatus(preBookHotelResponse.getReturnStatus());
        preResponse.setCancellations(preBookHotelResponse.getCancellations());
        preResponse.setTotalCommission(preBookHotelResponse.getTotalCommission());
        preResponse.setTotalPrice(preBookHotelResponse.getTotalPrice());
        preResponse.setVATOnCommission(preBookHotelResponse.getVATOnCommission());

        return preResponse;
    };

    public Function<PreBookRequest, PreBookHotelRequest> mapPreBookHotelRequest = preBookRequest -> {
        val preBoookHotelRequest = new PreBookHotelRequest();

        val loginDetails = getLoginDetails();

        val bookingDetails = new PreBookingDetails();
        bookingDetails.setArrivalDate(preBookRequest.getArrivalDate());
        bookingDetails.setDuration(preBookRequest.getDuration());
        bookingDetails.setPropertyID(preBookRequest.getPropertyID());
        bookingDetails.setPreRoomBookings(preBookRequest.getPreRoomBookings());

        preBoookHotelRequest.setLoginDetails(loginDetails);
        preBoookHotelRequest.setPreBookingDetails(bookingDetails);

        return preBoookHotelRequest;
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
