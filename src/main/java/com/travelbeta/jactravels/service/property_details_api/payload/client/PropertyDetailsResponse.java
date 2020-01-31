package com.travelbeta.jactravels.service.property_details_api.payload.client;


import com.travelbeta.jactravel.service.property_details_api.payload.jactravel.response.*;
import com.travelbeta.jactravels.service.property_details_api.payload.jactravel.response.*;
import com.travelbeta.jactravels.service.search_api.payload.travelbeta.response.ReturnStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Brume
 **/
@Data
public class PropertyDetailsResponse implements Serializable {

    private ReturnStatus returnStatus;

    private Integer propertyID;

    private Integer propertyReferenceID;

    private String propertyName;

    private Integer propertyTypeID;

    private String propertyType;

    private Double rating;

    private Integer geographyLevel1ID;

    private Integer geographyLevel2ID;

    private Integer geographyLevel3ID;

    private String country;

    private String region;

    private String resort;

    private String address1;

    private String address2;

    private String townCity;

    private String county;

    private String postCode;

    private String telephone;

    private String fax;

    private String latitude;

    private String longitude;

    private Integer minAdults;

    private Integer maxAdults;

    private Integer maxChildren;

    private String strapline;

    private String description;

    private String CMSBaseURL;

    private String mainImage;

    private String mainImageThumbnail;

    private List<Image> images;

    private List<PropertyRoomType> propertyRoomTypes;

    private List<ProductAttributeGroup> productAttributeGroups;

    private List<SpecialOffer> specialOffers;

    private String arrangements;

    private List<RestrictedArrival> restrictedArrivals;

    private List<MinMaxStay> minMaxStays;

}
