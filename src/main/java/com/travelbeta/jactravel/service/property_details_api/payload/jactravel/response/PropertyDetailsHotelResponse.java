package com.travelbeta.jactravel.service.property_details_api.payload.jactravel.response;


import lombok.Data;
import com.travelbeta.jactravel.service.search_api.payload.travelbeta.response.ReturnStatus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author Brume
 **/
@Data
@XmlRootElement(name = "PropertyDetailsResponse")
public class PropertyDetailsHotelResponse implements Serializable {

    @XmlElement(name = "ReturnStatus")
    private ReturnStatus returnStatus;

    @XmlElement(name = "PropertyID")
    private Integer propertyID;

    @XmlElement(name = "PropertyReferenceID")
    private Integer propertyReferenceID;

    @XmlElement(name = "PropertyName")
    private String propertyName;

    @XmlElement(name = "PropertyTypeID")
    private Integer propertyTypeID;

    @XmlElement(name = "PropertyType")
    private String propertyType;

    @XmlElement(name = "Rating")
    private Double rating;

    @XmlElement(name = "GeographyLevel1ID")
    private Integer geographyLevel1ID;

    @XmlElement(name = "GeographyLevel2ID")
    private Integer geographyLevel2ID;

    @XmlElement(name = "GeographyLevel3ID")
    private Integer geographyLevel3ID;

    @XmlElement(name = "Country")
    private String country;

    @XmlElement(name = "Region")
    private String region;

    @XmlElement(name = "Resort")
    private String resort;

    @XmlElement(name = "Address1")
    private String address1;

    @XmlElement(name = "Address2")
    private String address2;

    @XmlElement(name = "TownCity")
    private String townCity;

    @XmlElement(name = "County")
    private String county;

    @XmlElement(name = "PostCode")
    private String postCode;

    @XmlElement(name = "Telephone")
    private String telephone;

    @XmlElement(name = "Fax")
    private String fax;

    @XmlElement(name = "Latitude")
    private String latitude;

    @XmlElement(name = "Longitude")
    private String longitude;

    @XmlElement(name = "MinAdults")
    private Integer minAdults;

    @XmlElement(name = "MaxAdults")
    private Integer maxAdults;

    @XmlElement(name = "MaxChildren")
    private Integer maxChildren;

    @XmlElement(name = "Strapline")
    private String strapline;

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "CMSBaseURL")
    private String CMSBaseURL;

    @XmlElement(name = "MainImage")
    private String mainImage;

    @XmlElement(name = "MainImageThumbnail")
    private String mainImageThumbnail;

    @XmlElement(name = "Image")
    @XmlElementWrapper(name = "Images")
    private List<Image> images;

    @XmlElement(name = "PropertyRoomType")
    @XmlElementWrapper(name = "PropertyRoomTypes")
    private List<PropertyRoomType> propertyRoomTypes;

    @XmlElement(name = "ProductAttributeGroup")
    @XmlElementWrapper(name = "ProductAttributeGroups")
    private List<ProductAttributeGroup> productAttribtuteGroups;

    @XmlElement(name = "SpecialOffer")
    @XmlElementWrapper(name = "SpecialOffers")
    private List<SpecialOffer> specialOffers;

    @XmlElement(name = "Arrangements")
    private String arrangements;

    @XmlElement(name = "RestrictedArrival")
    @XmlElementWrapper(name = "RestrictedArrivals")
    private List<RestrictedArrival> restrictedArrivals;

    @XmlElement(name = "MinMaxStay")
    @XmlElementWrapper(name = "MinMaxStays")
    private List<MinMaxStay> minMaxStays;

}
