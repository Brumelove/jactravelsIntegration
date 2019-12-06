package org.javasoft.searchapi.booking_api.payload.jactravel.request;


import lombok.Data;
import org.javasoft.searchapi.payload.travelbeta.request.LoginDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Brume
 **/

@Data
@XmlRootElement(name = "PreBookRequest")
public class BookHotelRequest {

    @XmlElement(name = "LoginDetails")
    private LoginDetails loginDetails;

    @XmlElement(name = "BookingDetails")
    private BookingDetails bookingDetails;
}

