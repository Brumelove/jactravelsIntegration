package org.javasoft.searchapi.prebooking_api.util;


import lombok.val;
import org.javasoft.searchapi.config.TravelBetaConfig;
import org.javasoft.searchapi.payload.travelbeta.request.LoginDetails;
import org.javasoft.searchapi.prebooking_api.payload.client.PreBookRequest;
import org.javasoft.searchapi.prebooking_api.payload.client.PreBookResponse;
import org.javasoft.searchapi.prebooking_api.payload.jactravel.request.BookingDetails;
import org.javasoft.searchapi.prebooking_api.payload.jactravel.request.PreBookHotelRequest;
import org.javasoft.searchapi.prebooking_api.payload.jactravel.response.PreBookHotelResponse;
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

        val bookingDetails = new BookingDetails();
        bookingDetails.setArrivalDate(preBookRequest.getArrivalDate());
        bookingDetails.setDuration(preBookRequest.getDuration());
        bookingDetails.setPropertyID(preBookRequest.getPropertyID());
        bookingDetails.setRoomBookings(preBookRequest.getRoomBookings());

        preBoookHotelRequest.setLoginDetails(loginDetails);
        preBoookHotelRequest.setBookingDetails(bookingDetails);

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
