package com.travelbeta.jactravels.service.precancel_api.payload.jactravel.request;


import com.travelbeta.jactravels.service.search_api.payload.travelbeta.request.LoginDetails;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Brume
 **/

@Data
@XmlRootElement(name = "PreCancelRequest")
public class PreCancelHotelRequest {

    @XmlElement(name = "LoginDetails")
    private LoginDetails loginDetails;

    @XmlElement(name = "BookingReference")
    private String bookingReference;
}

