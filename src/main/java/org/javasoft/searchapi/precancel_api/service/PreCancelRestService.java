package org.javasoft.searchapi.precancel_api.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.javasoft.searchapi.bean.RestTemplateBean;
import org.javasoft.searchapi.precancel_api.payload.jactravel.request.PreCancelHotelRequest;
import org.javasoft.searchapi.precancel_api.payload.jactravel.response.PreCancelHotelResponse;
import org.javasoft.searchapi.util.EncodeUtil;
import org.springframework.stereotype.Service;

/**
 * @author Brume
 **/

@Slf4j
@Service
public class PreCancelRestService {

    private final RestTemplateBean restTemplateBean;

    private final EncodeUtil<PreCancelHotelRequest, PreCancelHotelResponse> encodeUtil;

    public PreCancelRestService(RestTemplateBean restTemplateBean, EncodeUtil<PreCancelHotelRequest, PreCancelHotelResponse> encodeUtil) {
        this.restTemplateBean = restTemplateBean;
        this.encodeUtil = encodeUtil;
    }




    public PreCancelHotelResponse handlePreCancelHotel(PreCancelHotelRequest preCancelHotelRequest) {
        val encodedString = encodeUtil.convertObjectToEncodedString(preCancelHotelRequest);
        log.info("Encoded String ::: {}", encodedString);
        val responseString = restTemplateBean.postRequestObject(encodedString);
        log.info("Response String ::: {}", responseString);
        if(StringUtils.isNotBlank(responseString)){
            return encodeUtil.convertEncodedStringToObject(responseString, new PreCancelHotelResponse());
        }
        return null;
    }
}
