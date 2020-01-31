package com.travelbeta.jactravels.service.multi_book_search_api.payload.jactravel.response;


import com.travelbeta.jactravels.service.search_api.payload.travelbeta.response.ReturnStatus;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author Brume
 **/
@Data
@XmlRootElement(name = "MultiBookingSearchResponse")
public class MultiBookSearchHotelResponse implements Serializable {

    @XmlElement(name = "ReturnStatus")
    private ReturnStatus returnStatus;

    @XmlElement(name = "Booking")
    @XmlElementWrapper(name = "Bookings")
    private List<Booking> bookings;

}
