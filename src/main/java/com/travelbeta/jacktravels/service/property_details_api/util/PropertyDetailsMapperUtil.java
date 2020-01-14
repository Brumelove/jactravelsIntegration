package com.travelbeta.jacktravels.service.property_details_api.util;


import lombok.val;
import com.travelbeta.jacktravels.service.config.TravelBetaConfig;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.request.LoginDetails;
import com.travelbeta.jacktravels.service.property_details_api.payload.client.PropertyDetailsRequest;
import com.travelbeta.jacktravels.service.property_details_api.payload.client.PropertyDetailsResponse;
import com.travelbeta.jacktravels.service.property_details_api.payload.jactravel.request.PropertyDetailsHotelRequest;
import com.travelbeta.jacktravels.service.property_details_api.payload.jactravel.response.PropertyDetailsHotelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author Brume
 **/
@Component
public class PropertyDetailsMapperUtil {
    private TravelBetaConfig travelBetaConfig;

    @Autowired
    public PropertyDetailsMapperUtil(TravelBetaConfig travelBetaConfig) {
        this.travelBetaConfig = travelBetaConfig;
    }


    public Function<PropertyDetailsHotelResponse, PropertyDetailsResponse> mapPropertyDetailsResponse = propertyDetailsHotelResponse -> {
        val propertyDetailsResponse = new PropertyDetailsResponse();
        propertyDetailsResponse.setReturnStatus(propertyDetailsHotelResponse.getReturnStatus());
        propertyDetailsResponse.setAddress1(propertyDetailsHotelResponse.getAddress1());
        propertyDetailsResponse.setAddress2(propertyDetailsHotelResponse.getAddress2());
        propertyDetailsResponse.setArrangements(propertyDetailsHotelResponse.getArrangements());
        propertyDetailsResponse.setCMSBaseURL(propertyDetailsHotelResponse.getCMSBaseURL());
        propertyDetailsResponse.setCountry(propertyDetailsHotelResponse.getCountry());
        propertyDetailsResponse.setDescription(propertyDetailsHotelResponse.getDescription());
        propertyDetailsResponse.setFax(propertyDetailsHotelResponse.getFax());
        propertyDetailsResponse.setCounty(propertyDetailsHotelResponse.getCounty());
        propertyDetailsResponse.setGeographyLevel1ID(propertyDetailsHotelResponse.getGeographyLevel1ID());
        propertyDetailsResponse.setGeographyLevel2ID(propertyDetailsHotelResponse.getGeographyLevel2ID());
        propertyDetailsResponse.setGeographyLevel3ID(propertyDetailsHotelResponse.getGeographyLevel3ID());
        propertyDetailsResponse.setImages(propertyDetailsResponse.getImages());
        propertyDetailsResponse.setLatitude(propertyDetailsHotelResponse.getLatitude());
        propertyDetailsResponse.setLongitude(propertyDetailsHotelResponse.getLongitude());
        propertyDetailsResponse.setMainImage(propertyDetailsHotelResponse.getMainImage());
        propertyDetailsResponse.setMainImageThumbnail(propertyDetailsHotelResponse.getMainImageThumbnail());
        propertyDetailsResponse.setMaxChildren(propertyDetailsHotelResponse.getMaxChildren());
        propertyDetailsResponse.setMinAdults(propertyDetailsHotelResponse.getMinAdults());
        propertyDetailsResponse.setMaxAdults(propertyDetailsHotelResponse.getMaxAdults());
        propertyDetailsResponse.setMinMaxStays(propertyDetailsHotelResponse.getMinMaxStays());
        propertyDetailsResponse.setPostCode(propertyDetailsHotelResponse.getPostCode());
        propertyDetailsResponse.setProductAttribtuteGroups(propertyDetailsHotelResponse.getProductAttribtuteGroups());
        propertyDetailsResponse.setPropertyID(propertyDetailsHotelResponse.getPropertyID());
        propertyDetailsResponse.setPropertyName(propertyDetailsHotelResponse.getPropertyName());
        propertyDetailsResponse.setPropertyReferenceID(propertyDetailsHotelResponse.getPropertyReferenceID());
        propertyDetailsResponse.setPropertyRoomTypes(propertyDetailsHotelResponse.getPropertyRoomTypes());
        propertyDetailsResponse.setPropertyType(propertyDetailsHotelResponse.getPropertyType());
        propertyDetailsResponse.setPropertyTypeID(propertyDetailsHotelResponse.getPropertyTypeID());
        propertyDetailsResponse.setRating(propertyDetailsHotelResponse.getRating());
        propertyDetailsResponse.setRegion(propertyDetailsHotelResponse.getRegion());
        propertyDetailsResponse.setResort(propertyDetailsHotelResponse.getResort());
        propertyDetailsResponse.setRestrictedArrivals(propertyDetailsHotelResponse.getRestrictedArrivals());
        propertyDetailsResponse.setSpecialOffers(propertyDetailsHotelResponse.getSpecialOffers());
        propertyDetailsResponse.setStrapline(propertyDetailsHotelResponse.getStrapline());
        propertyDetailsResponse.setTelephone(propertyDetailsHotelResponse.getTelephone());
        propertyDetailsResponse.setTownCity(propertyDetailsHotelResponse.getTownCity());

        return propertyDetailsResponse;
    };

    public Function<PropertyDetailsRequest, PropertyDetailsHotelRequest> mapPropertyDetailsHotelRequest = propertyDetailsRequest -> {
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
