package com.travelbeta.jactravels.service.booking_api.payload.client;


import lombok.Data;
import com.travelbeta.jactravels.service.booking_api.payload.jactravel.request.RoomBooking;

import java.util.List;

/**
 * @author Brume
 **/

@Data
public class BookRequest {

    private Integer propertyID;

    private String arrivalDate;

    private Integer duration;

    private String preBookingToken;

    private String leadGuestTitle;

    private String leadGuestFirstName;

    private String leadGuestLastName;

    private String leadGuestAddress1;

    private String leadGuestAddress2;

    private String leadGuestTownCity;

    private String leadGuestCounty;

    private String leadGuestPostCode;

    private Integer leadGuestBookingCountryID;

    private String leadGuestPhone;

    private String leadGuestFax;

    private String leadGuestEmail;

    private String request;

    private String tradeReference;

    private List<RoomBooking> roomBookings;
}

