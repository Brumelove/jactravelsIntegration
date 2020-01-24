package com.travelbeta.jactravel.service.property_details_api.payload.client;


import lombok.Data;

import java.util.Date;

/**
 * @author Brume
 **/

@Data
public class PropertyDetailsRequest {

    private Integer propertyID;

    private Integer propertyReferenceID;
}

