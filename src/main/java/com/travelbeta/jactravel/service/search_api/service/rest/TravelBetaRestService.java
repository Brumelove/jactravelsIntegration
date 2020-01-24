package com.travelbeta.jactravel.service.search_api.service.rest;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import com.travelbeta.jactravel.service.bean.RestTemplateBean;
import com.travelbeta.jactravel.service.search_api.payload.travelbeta.request.SearchHotelRequest;
import com.travelbeta.jactravel.service.search_api.payload.travelbeta.response.SearchHotelResponse;
import com.travelbeta.jactravel.service.search_api.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TravelBetaRestService {

    private final RestTemplateBean restTemplateBean;

    private final EncodeUtil<SearchHotelRequest,SearchHotelResponse> encodeUtil;

    @Autowired
    public TravelBetaRestService(RestTemplateBean restTemplateBean, EncodeUtil<SearchHotelRequest,SearchHotelResponse> encodeUtil) {
        this.restTemplateBean = restTemplateBean;
        this.encodeUtil = encodeUtil;
    }

    public SearchHotelResponse handleSearchHotel(SearchHotelRequest searchHotelRequest){
        val encodedString = encodeUtil.convertObjectToEncodedString(searchHotelRequest);
        log.info("Encoded String ::: {}", encodedString);
        val responseString = restTemplateBean.postRequestObject(encodedString);
        log.info("Response String ::: {}", responseString);
        if(StringUtils.isNotBlank(responseString)){
            return encodeUtil.convertEncodedStringToObject(responseString, new SearchHotelResponse());
        }
        return null;
    }
}
