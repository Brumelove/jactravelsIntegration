package org.javasoft.searchapi.book_search_api.payload.jactravel.request;


import lombok.Data;
import org.javasoft.searchapi.payload.travelbeta.request.LoginDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

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

