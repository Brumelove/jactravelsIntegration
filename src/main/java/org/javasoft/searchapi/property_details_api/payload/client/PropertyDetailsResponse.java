package org.javasoft.searchapi.property_details_api.payload.client;


import lombok.Data;
import org.javasoft.searchapi.multi_book_search_api.payload.jactravel.response.Booking;
import org.javasoft.searchapi.payload.travelbeta.response.ReturnStatus;

import java.io.Serializable;
import java.util.List;

/**
 * @author Brume
 **/
@Data
public class PropertyDetailsResponse implements Serializable {

    private ReturnStatus returnStatus;

    private List<Booking> bookings;

}
