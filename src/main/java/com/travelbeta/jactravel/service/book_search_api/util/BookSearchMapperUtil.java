package com.travelbeta.jactravel.service.book_search_api.util;


import lombok.val;
import com.travelbeta.jactravel.service.config.TravelBetaConfig;
import com.travelbeta.jactravel.service.search_api.payload.travelbeta.request.LoginDetails;
import com.travelbeta.jactravel.service.book_search_api.payload.client.BookSearchRequest;
import com.travelbeta.jactravel.service.book_search_api.payload.client.BookSearchResponse;
import com.travelbeta.jactravel.service.book_search_api.payload.jactravel.request.BookSearchHotelRequest;
import com.travelbeta.jactravel.service.book_search_api.payload.jactravel.response.BookSearchHotelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author Brume
 **/
@Component
public class BookSearchMapperUtil {
    private TravelBetaConfig travelBetaConfig;

    @Autowired
    public BookSearchMapperUtil(TravelBetaConfig travelBetaConfig) {
        this.travelBetaConfig = travelBetaConfig;
    }


    public Function<BookSearchHotelResponse, BookSearchResponse> mapBookSearchResponse = bookSearchHotelResponse -> {
        val bookSearchResponse = new BookSearchResponse();
        bookSearchResponse.setReturnStatus(bookSearchHotelResponse.getReturnStatus());
        bookSearchResponse.setAccountStatus(bookSearchHotelResponse.getAccountStatus());
        bookSearchResponse.setAdjustments(bookSearchHotelResponse.getAdjustments());
        bookSearchResponse.setBookingReference(bookSearchHotelResponse.getBookingReference());
        bookSearchResponse.setComments(bookSearchHotelResponse.getComments());
        bookSearchResponse.setCurrencyID(bookSearchHotelResponse.getCurrencyID());
        bookSearchResponse.setErrata(bookSearchHotelResponse.getErrata());
        bookSearchResponse.setLeadGuestAddress1(bookSearchHotelResponse.getLeadGuestAddress1());
        bookSearchResponse.setLeadGuestAddress2(bookSearchHotelResponse.getLeadGuestAddress2());
        bookSearchResponse.setLeadGuestBookingCountryID(bookSearchHotelResponse.getLeadGuestBookingCountryID());
        bookSearchResponse.setLeadGuestEmail(bookSearchHotelResponse.getLeadGuestEmail());
        bookSearchResponse.setLeadGuestFax(bookSearchHotelResponse.getLeadGuestFax());
        bookSearchResponse.setLeadGuestFirstName(bookSearchHotelResponse.getLeadGuestFirstName());
        bookSearchResponse.setLeadGuestLastName(bookSearchHotelResponse.getLeadGuestLastName());
        bookSearchResponse.setLeadGuestPhone(bookSearchHotelResponse.getLeadGuestPhone());
        bookSearchResponse.setLeadGuestPostCode(bookSearchHotelResponse.getLeadGuestPostCode());
        bookSearchResponse.setLeadGuestTitle(bookSearchHotelResponse.getLeadGuestTitle());
        bookSearchResponse.setLeadGuestTownCity(bookSearchHotelResponse.getLeadGuestTownCity());
        bookSearchResponse.setOptionalSupplements(bookSearchHotelResponse.getOptionalSupplements());
        bookSearchResponse.setProperties(bookSearchHotelResponse.getProperties());
        bookSearchResponse.setRooms(bookSearchHotelResponse.getRooms());
        bookSearchResponse.setStatus(bookSearchHotelResponse.getStatus());
        bookSearchResponse.setTotalCommission(bookSearchHotelResponse.getTotalCommission());
        bookSearchResponse.setTotalOutstanding(bookSearchHotelResponse.getTotalOutstanding());
        bookSearchResponse.setTotalPrice(bookSearchHotelResponse.getTotalPrice());

        return bookSearchResponse;
    };

    public Function<BookSearchRequest, BookSearchHotelRequest> mapBookSearchHotelRequest = bookSearchRequest -> {
        val bookSearchHotelRequest = new BookSearchHotelRequest();

        val loginDetails = getLoginDetails();

        bookSearchHotelRequest.setLoginDetails(loginDetails);
        bookSearchHotelRequest.setBookingReference(bookSearchRequest.getBookingReference());


        return bookSearchHotelRequest;
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
