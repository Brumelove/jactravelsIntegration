package com.travelbeta.jactravels.service.cancel_api.service;

import com.travelbeta.jactravels.service.bean.RestTemplateBean;
import com.travelbeta.jactravels.service.cancel_api.payload.jactravel.request.CancelHotelRequest;
import com.travelbeta.jactravels.service.cancel_api.payload.jactravel.response.CancelHotelResponse;
import com.travelbeta.jactravels.service.search_api.util.EncodeUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author Brume
 **/

@Slf4j
@Service
public class CancelRestService {

    private final RestTemplateBean restTemplateBean;

    private final EncodeUtil<CancelHotelRequest, CancelHotelResponse> encodeUtil;

    public CancelRestService(RestTemplateBean restTemplateBean, EncodeUtil<CancelHotelRequest, CancelHotelResponse> encodeUtil) {
        this.restTemplateBean = restTemplateBean;
        this.encodeUtil = encodeUtil;
    }




    public CancelHotelResponse handleCancelHotel(CancelHotelRequest cancelHotelRequest) {
        val encodedString = encodeUtil.convertObjectToEncodedString(cancelHotelRequest);
        log.info("Encoded String ::: {}", encodedString);
        val responseString = restTemplateBean.postRequestObject(encodedString);
        log.info("Response String ::: {}", responseString);
        if(StringUtils.isNotBlank(responseString)){
            return encodeUtil.convertEncodedStringToObject(responseString, new CancelHotelResponse());
        }
        return null;
    }
}
