package com.travelbeta.jacktravels.service.prebooking_api.payload.client;


import lombok.Data;
import com.travelbeta.jacktravels.service.prebooking_api.payload.jactravel.request.PreRoomBooking;

import java.util.List;

/**
 * @author Brume
 **/

@Data
public class PreBookRequest {
    private Integer propertyID;
    private String arrivalDate;
    private Integer duration;
    private List<PreRoomBooking> preRoomBookings;
}

