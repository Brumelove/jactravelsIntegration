package org.javasoft.searchapi.multi_book_search_api.payload.jactravel.request;


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
public class MultiBookSearchHotelRequest {

    @XmlElement(name = "LoginDetails")
    private LoginDetails loginDetails;

    @XmlElement(name = "BookingCreationStartDate")
    private Date bookingCreationStartDate;

    @XmlElement(name = "BookingCreationEndDate")
    private Date bookingCreationEndDate;

    @XmlElement(name = "AllComponents")
    private boolean allComponents;
}

