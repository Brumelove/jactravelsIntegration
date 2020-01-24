package com.travelbeta.jactravel.service.book_search_api.payload.client;


import com.travelbeta.jactravel.service.book_search_api.payload.jactravel.response.*;
import lombok.Data;
import com.travelbeta.jactravel.service.search_api.payload.travelbeta.response.ReturnStatus;

import java.io.Serializable;
import java.util.List;

/**
 * @author Brume
 **/
@Data
public class BookSearchResponse implements Serializable {

    private ReturnStatus returnStatus;

    private Integer currencyID;

    private String bookingReference;

    private String status;

    private String accountStatus;

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

    private Double totalPrice;

    private Double totalOutstanding;

    private Double totalCommission;

    private List<Property> properties;

    private List<Room> rooms;

    private List<Adjustment> adjustments;

    private List<OptionalSupplement> optionalSupplements;

    private List<Erratum> errata;

    private List<Comment> comments;

}
