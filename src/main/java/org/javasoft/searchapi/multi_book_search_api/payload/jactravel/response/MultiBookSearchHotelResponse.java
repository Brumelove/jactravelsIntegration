package org.javasoft.searchapi.multi_book_search_api.payload.jactravel.response;


import lombok.Data;
import org.javasoft.searchapi.payload.travelbeta.response.ReturnStatus;

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
