package org.javasoft.searchapi.property_details_api.util;


import lombok.val;
import org.javasoft.searchapi.config.TravelBetaConfig;
import org.javasoft.searchapi.payload.travelbeta.request.LoginDetails;
import org.javasoft.searchapi.property_details_api.payload.client.PropertyDetailsRequest;
import org.javasoft.searchapi.property_details_api.payload.client.PropertyDetailsResponse;
import org.javasoft.searchapi.property_details_api.payload.jactravel.request.PropertyDetailsHotelRequest;
import org.javasoft.searchapi.property_details_api.payload.jactravel.response.PropertyDetailsHotelResponse;
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


    public Function<PropertyDetailsHotelResponse, PropertyDetailsResponse> mapPreCancelResponse = propertyDetailsHotelResponse -> {
        val multiBookSearchResponse = new PropertyDetailsResponse();
        propertyDetailsHotelResponse.setReturnStatus(propertyDetailsHotelResponse.getReturnStatus());
        propertyDetailsHotelResponse.setBookings(propertyDetailsHotelResponse.getBookings());

        return multiBookSearchResponse;
    };

    public Function<PropertyDetailsRequest, PropertyDetailsHotelRequest> mapMultiBookSearchHotelRequest = propertyDetailsRequest -> {
        val preCancelHotelRequest = new PropertyDetailsHotelRequest();

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
