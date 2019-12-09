package org.javasoft.searchapi.book_search_api.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.javasoft.searchapi.bean.RestTemplateBean;
import org.javasoft.searchapi.book_search_api.payload.jactravel.request.BookSearchHotelRequest;
import org.javasoft.searchapi.book_search_api.payload.jactravel.response.BookSearchHotelResponse;
import org.javasoft.searchapi.util.EncodeUtil;
import org.springframework.stereotype.Service;

/**
 * @author Brume
 **/

@Slf4j
@Service
public class BookSearchRestService {

    private final RestTemplateBean restTemplateBean;

    private final EncodeUtil<BookSearchHotelRequest, BookSearchHotelResponse> encodeUtil;

    public BookSearchRestService(RestTemplateBean restTemplateBean, EncodeUtil<BookSearchHotelRequest, BookSearchHotelResponse> encodeUtil) {
        this.restTemplateBean = restTemplateBean;
        this.encodeUtil = encodeUtil;
    }




    public BookSearchHotelResponse handleBookSearchHotel(BookSearchHotelRequest bookSearchHotelRequest) {
        val encodedString = encodeUtil.convertObjectToEncodedString(bookSearchHotelRequest);
        log.info("Encoded String ::: {}", encodedString);
        val responseString = restTemplateBean.postRequestObject(encodedString);
        log.info("Response String ::: {}", responseString);
        if(StringUtils.isNotBlank(responseString)){
            return encodeUtil.convertEncodedStringToObject(responseString, new BookSearchHotelResponse());
        }
        return null;
    }
}
