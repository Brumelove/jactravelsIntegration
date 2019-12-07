package org.javasoft.searchapi.property_details_api.payload.jactravel.request;


import lombok.Data;
import org.javasoft.searchapi.payload.travelbeta.request.LoginDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author Brume
 **/

@Data
@XmlRootElement(name = "MultiBookingSearchRequest")
public class PropertyDetailsHotelRequest {

    @XmlElement(name = "LoginDetails")
    private LoginDetails loginDetails;

    @XmlElement(name = "PropertyID")
    private Integer propertyID;

    @XmlElement(name = "PropertyReferenceID")
    private Integer propertyReferenceID;
}

