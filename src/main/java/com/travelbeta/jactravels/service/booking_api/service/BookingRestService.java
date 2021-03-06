package com.travelbeta.jactravels.service.booking_api.service;

import com.travelbeta.jactravels.service.bean.RestTemplateBean;
import com.travelbeta.jactravels.service.booking_api.payload.jactravel.request.BookHotelRequest;
import com.travelbeta.jactravels.service.search_api.util.EncodeUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import com.travelbeta.jactravels.service.booking_api.payload.jactravel.response.BookHotelResponse;
import org.springframework.stereotype.Service;

/**
 * @author Brume
 **/

@Slf4j
@Service
public class BookingRestService {

    private final RestTemplateBean restTemplateBean;

    private final EncodeUtil<BookHotelRequest, BookHotelResponse> encodeUtil;

    public BookingRestService(RestTemplateBean restTemplateBean, EncodeUtil<BookHotelRequest, BookHotelResponse> encodeUtil) {
        this.restTemplateBean = restTemplateBean;
        this.encodeUtil = encodeUtil;
    }




    public BookHotelResponse handleBookHotel(BookHotelRequest bookHotelRequest) {
        val encodedString = encodeUtil.convertObjectToEncodedString(bookHotelRequest);
        log.info("Encoded String ::: {}", encodedString);
        val responseString = restTemplateBean.postRequestObject(encodedString);
        log.info("Response String ::: {}", responseString);
        if(StringUtils.isNotBlank(responseString)){
            return encodeUtil.convertEncodedStringToObject(responseString, new BookHotelResponse());
        }
        return null;
    }
}
