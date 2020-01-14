package com.travelbeta.jacktravels.service.booking_api.payload.client;


import lombok.Data;
import com.travelbeta.jacktravels.service.booking_api.payload.jactravel.response.PaymentDue;
import com.travelbeta.jacktravels.service.booking_api.payload.jactravel.response.PropertyBooking;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.response.ReturnStatus;

import java.io.Serializable;
import java.util.List;

/**
 * @author Brume
 **/
@Data
public class BookResponse implements Serializable {

    private ReturnStatus returnStatus;

    private Integer currencyID;

    private String bookingReference;

    private String tradeReference;

    private Double totalPrice;

    private Double totalCommission;

    private Double customerTotalPrice;

    private List<PaymentDue> paymentDue;

    private List<PropertyBooking> propertyBookings;


}
