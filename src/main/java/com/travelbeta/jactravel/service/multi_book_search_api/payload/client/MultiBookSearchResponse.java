package com.travelbeta.jactravel.service.multi_book_search_api.payload.client;


import lombok.Data;
import com.travelbeta.jactravel.service.multi_book_search_api.payload.jactravel.response.Booking;
import com.travelbeta.jactravel.service.search_api.payload.travelbeta.response.ReturnStatus;

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
