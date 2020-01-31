package com.travelbeta.jactravels.service.property_details_api.payload.jactravel.request;


import com.travelbeta.jactravels.service.search_api.payload.travelbeta.request.LoginDetails;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Brume
 **/

@Data
@XmlRootElement(name = "PropertyDetailsRequest")
public class PropertyDetailsHotelRequest {

    @XmlElement(name = "LoginDetails")
    private LoginDetails loginDetails;

    @XmlElement(name = "PropertyID")
    private Integer propertyID;

    @XmlElement(name = "PropertyReferenceID")
    private Integer propertyReferenceID;
}

