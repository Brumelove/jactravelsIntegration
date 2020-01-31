package com.travelbeta.jactravels.service.multi_book_search_api.payload.client;


import com.travelbeta.jactravels.service.search_api.payload.travelbeta.response.ReturnStatus;
import lombok.Data;
import com.travelbeta.jactravels.service.multi_book_search_api.payload.jactravel.response.Booking;

import java.io.Serializable;
import java.util.List;

/**
 * @author Brume
 **/
@Data
public class MultiBookSearchResponse implements Serializable {

    private ReturnStatus returnStatus;

    private List<Booking> bookings;

}
