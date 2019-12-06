package org.javasoft.searchapi.booking_api.util;


import lombok.val;
import org.javasoft.searchapi.booking_api.payload.client.BookRequest;
import org.javasoft.searchapi.booking_api.payload.client.BookResponse;
import org.javasoft.searchapi.booking_api.payload.jactravel.request.BookingDetails;
import org.javasoft.searchapi.booking_api.payload.jactravel.request.BookHotelRequest;
import org.javasoft.searchapi.booking_api.payload.jactravel.response.BookHotelResponse;
import org.javasoft.searchapi.config.TravelBetaConfig;
import org.javasoft.searchapi.payload.travelbeta.request.LoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author Brume
 **/
@Component
public class BookMapperUtil {
    private TravelBetaConfig travelBetaConfig;

    @Autowired
    public BookMapperUtil(TravelBetaConfig travelBetaConfig) {
        this.travelBetaConfig = travelBetaConfig;
    }


    public Function<BookHotelResponse, BookResponse> mapBookResponse = bookHotelResponse -> {
        val preResponse = new BookResponse();
        preResponse.setCurrencyID(bookHotelResponse.getCurrencyID());
        preResponse.setReturnStatus(bookHotelResponse.getReturnStatus());
        preResponse.setBookingReference(bookHotelResponse.getBookingReference());
        preResponse.setCustomerTotalPrice(bookHotelResponse.getCustomerTotalPrice());
        preResponse.setPaymentDue(bookHotelResponse.getPaymentDue());
        preResponse.setTotalCommission(bookHotelResponse.getCustomerTotalPrice());
        preResponse.setPropertyBookings(bookHotelResponse.getPropertyBookings());
        preResponse.setTradeReference(bookHotelResponse.getTradeReference());
        preResponse.setCustomerTotalPrice(bookHotelResponse.getCustomerTotalPrice());
        return preResponse;
    };

    public Function<BookRequest, BookHotelRequest> mapBookHotelRequest = bookRequest -> {
        val bookHotelRequest = new BookHotelRequest();

        val loginDetails = getLoginDetails();

        val bookingDetails = new BookingDetails();
        bookingDetails.setArrivalDate(bookRequest.getArrivalDate());
        bookingDetails.setDuration(bookRequest.getDuration());
        bookingDetails.setPropertyID(bookRequest.getPropertyID());
        bookingDetails.setPreBookingToken(bookRequest.getPreBookingToken());
        bookingDetails.setTradeReference(bookRequest.getTradeReference());
        bookingDetails.setRequest(bookRequest.getRequest());
        bookingDetails.setRoomBookings(bookRequest.getRoomBookings());
        bookingDetails.setLeadGuestAddress1(bookRequest.getLeadGuestAddress1());
        bookingDetails.setLeadGuestAddress2(bookRequest.getLeadGuestAddress2());
        bookingDetails.setLeadGuestBookingCountryID(bookRequest.getLeadGuestBookingCountryID());
        bookingDetails.setLeadGuestEmail(bookRequest.getLeadGuestEmail());
        bookingDetails.setLeadGuestFax(bookRequest.getLeadGuestFax());
        bookingDetails.setLeadGuestFirstName(bookRequest.getLeadGuestFirstName());
        bookingDetails.setLeadGuestLastName(bookRequest.getLeadGuestLastName());
        bookingDetails.setLeadGuestPhone(bookRequest.getLeadGuestPhone());
        bookingDetails.setLeadGuestPostCode(bookRequest.getLeadGuestPostCode());
        bookingDetails.setLeadGuestTitle(bookRequest.getLeadGuestTitle());
        bookingDetails.setLeadGuestTownCity(bookRequest.getLeadGuestTownCity());

        bookHotelRequest.setLoginDetails(loginDetails);
        bookHotelRequest.setBookingDetails(bookingDetails);

        return bookHotelRequest;
    };

    private LoginDetails getLoginDetails() {
        val loginDetails = new LoginDetails();
        loginDetails.setAgentReference("");
        loginDetails.setCurrencyID(2);
        loginDetails.setLocale("");
        loginDetails.setLogin(travelBetaConfig.getUsername());
        loginDetails.setPassword(travelBetaConfig.getPassword());
        return loginDetails;
    }

}
