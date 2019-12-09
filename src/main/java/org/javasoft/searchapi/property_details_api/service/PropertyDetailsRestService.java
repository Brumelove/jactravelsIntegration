package org.javasoft.searchapi.property_details_api.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.javasoft.searchapi.bean.RestTemplateBean;
import org.javasoft.searchapi.property_details_api.payload.jactravel.request.PropertyDetailsHotelRequest;
import org.javasoft.searchapi.property_details_api.payload.jactravel.response.PropertyDetailsHotelResponse;
import org.javasoft.searchapi.util.EncodeUtil;
import org.springframework.stereotype.Service;

/**
 * @author Brume
 **/

@Slf4j
@Service
public class PropertyDetailsRestService {

    private final RestTemplateBean restTemplateBean;

    private final EncodeUtil<PropertyDetailsHotelRequest, PropertyDetailsHotelResponse> encodeUtil;

    public PropertyDetailsRestService(RestTemplateBean restTemplateBean, EncodeUtil<PropertyDetailsHotelRequest, PropertyDetailsHotelResponse> encodeUtil) {
        this.restTemplateBean = restTemplateBean;
        this.encodeUtil = encodeUtil;
    }




    public PropertyDetailsHotelResponse handlePropertyDetailsHotel(PropertyDetailsHotelRequest propertyDetailsHotelRequest) {
        val encodedString = encodeUtil.convertObjectToEncodedString(propertyDetailsHotelRequest);
        log.info("Encoded String ::: {}", encodedString);
        val responseString = restTemplateBean.postRequestObject(encodedString);
        log.info("Response String ::: {}", responseString);
        if(StringUtils.isNotBlank(responseString)){
            return encodeUtil.convertEncodedStringToObject(responseString, new PropertyDetailsHotelResponse());
        }
        return null;
    }
}
