package org.javasoft.searchapi.prebooking_api.payload.client;


import lombok.Data;
import org.javasoft.searchapi.prebooking_api.payload.jactravel.request.RoomBooking;

import java.util.List;

/**
 * @author Brume
 **/

@Data
public class PreBookRequest {
    private Integer propertyID;

    private String arrivalDate;
    private Integer duration;
    private List<RoomBooking> roomBookings;
}

