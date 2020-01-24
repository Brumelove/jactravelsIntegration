package com.travelbeta.jactravel.service.prebooking_api.payload.jactravel.request;


import lombok.Data;
import com.travelbeta.jactravel.service.search_api.payload.travelbeta.request.LoginDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Brume
 **/

@Data
@XmlRootElement(name = "PreBookRequest")
public class PreBookHotelRequest {

    @XmlElement(name = "LoginDetails")
    private LoginDetails loginDetails;

    @XmlElement(name = "BookingDetails")
    private PreBookingDetails preBookingDetails;
}

