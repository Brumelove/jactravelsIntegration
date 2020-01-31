package com.travelbeta.jactravels.service.prebooking_api.payload.jactravel.request;


import com.travelbeta.jactravels.service.search_api.payload.travelbeta.request.LoginDetails;
import lombok.Data;

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

