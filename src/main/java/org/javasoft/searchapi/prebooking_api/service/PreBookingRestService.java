package org.javasoft.searchapi.prebooking_api.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.javasoft.searchapi.bean.RestTemplateBean;
import org.javasoft.searchapi.prebooking_api.payload.jactravel.request.PreBookHotelRequest;
import org.javasoft.searchapi.prebooking_api.payload.jactravel.response.PreBookHotelResponse;
import org.javasoft.searchapi.util.EncodeUtil;
import org.springframework.stereotype.Service;

/**
 * @author Brume
 **/

@Slf4j
@Service
public class PreBookingRestService {

    private final RestTemplateBean restTemplateBean;

    private final EncodeUtil<PreBookHotelRequest, PreBookHotelResponse> encodeUtil;

    public PreBookingRestService(RestTemplateBean restTemplateBean, EncodeUtil<PreBookHotelRequest, PreBookHotelResponse> encodeUtil) {
        this.restTemplateBean = restTemplateBean;
        this.encodeUtil = encodeUtil;
    }




    public PreBookHotelResponse handlePreBookHotel(PreBookHotelRequest preBookHotelRequest) {
        val encodedString = encodeUtil.convertObjectToEncodedString(preBookHotelRequest);
        log.info("Encoded String ::: {}", encodedString);
        val responseString = restTemplateBean.postRequestObject(encodedString);
        log.info("Response String ::: {}", responseString);
        if(StringUtils.isNotBlank(responseString)){
            return encodeUtil.convertEncodedStringToObject(responseString, new PreBookHotelResponse());
        }
        return null;
    }
}
