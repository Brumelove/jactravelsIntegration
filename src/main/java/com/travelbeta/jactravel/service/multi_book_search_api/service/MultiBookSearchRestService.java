package com.travelbeta.jactravel.service.multi_book_search_api.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import com.travelbeta.jactravel.service.bean.RestTemplateBean;
import com.travelbeta.jactravel.service.multi_book_search_api.payload.jactravel.request.MultiBookSearchHotelRequest;
import com.travelbeta.jactravel.service.multi_book_search_api.payload.jactravel.response.MultiBookSearchHotelResponse;
import com.travelbeta.jactravel.service.search_api.util.EncodeUtil;
import org.springframework.stereotype.Service;

/**
 * @author Brume
 **/

@Slf4j
@Service
public class MultiBookSearchRestService {

    private final RestTemplateBean restTemplateBean;

    private final EncodeUtil<MultiBookSearchHotelRequest, MultiBookSearchHotelResponse> encodeUtil;

    public MultiBookSearchRestService(RestTemplateBean restTemplateBean, EncodeUtil<MultiBookSearchHotelRequest, MultiBookSearchHotelResponse> encodeUtil) {
        this.restTemplateBean = restTemplateBean;
        this.encodeUtil = encodeUtil;
    }




    public MultiBookSearchHotelResponse handleMultiBookSearchHotel(MultiBookSearchHotelRequest multiBookSearchHotelRequest) {
        val encodedString = encodeUtil.convertObjectToEncodedString(multiBookSearchHotelRequest);
        log.info("Encoded String ::: {}", encodedString);
        val responseString = restTemplateBean.postRequestObject(encodedString);
        log.info("Response String ::: {}", responseString);
        if(StringUtils.isNotBlank(responseString)){
            return encodeUtil.convertEncodedStringToObject(responseString, new MultiBookSearchHotelResponse());
        }
        return null;
    }
}
