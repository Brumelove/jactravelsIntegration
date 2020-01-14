package com.travelbeta.jacktravels.service.book_search_api.payload.jactravel.request;


import lombok.Data;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.request.LoginDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Brume
 **/

@Data
@XmlRootElement(name = "BookRequest")
public class BookSearchHotelRequest {

    @XmlElement(name = "LoginDetails")
    private LoginDetails loginDetails;

    @XmlElement(name = "BookingReference")
    private Integer bookingReference;

}

