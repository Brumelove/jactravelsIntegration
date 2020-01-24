package com.travelbeta.jactravel.service.property_details_api.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import com.travelbeta.jactravel.service.bean.RestTemplateBean;
import com.travelbeta.jactravel.service.property_details_api.payload.jactravel.request.PropertyDetailsHotelRequest;
import com.travelbeta.jactravel.service.property_details_api.payload.jactravel.response.PropertyDetailsHotelResponse;
import com.travelbeta.jactravel.service.search_api.util.EncodeUtil;
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
