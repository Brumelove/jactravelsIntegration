package com.travelbeta.jacktravels.service.multi_book_search_api.payload.client;


import lombok.Data;
import com.travelbeta.jacktravels.service.multi_book_search_api.payload.jactravel.response.Booking;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.response.ReturnStatus;

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
