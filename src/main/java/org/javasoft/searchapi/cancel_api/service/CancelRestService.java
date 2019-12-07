package org.javasoft.searchapi.cancel_api.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.javasoft.searchapi.bean.RestTemplateBean;
import org.javasoft.searchapi.cancel_api.payload.jactravel.request.CancelHotelRequest;
import org.javasoft.searchapi.cancel_api.payload.jactravel.response.CancelHotelResponse;
import org.javasoft.searchapi.util.EncodeUtil;
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
