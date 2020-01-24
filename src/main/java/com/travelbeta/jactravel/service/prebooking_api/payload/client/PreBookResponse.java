package com.travelbeta.jactravel.service.prebooking_api.payload.client;


import lombok.Data;
import com.travelbeta.jactravel.service.search_api.payload.travelbeta.response.ReturnStatus;
import com.travelbeta.jactravel.service.prebooking_api.payload.jactravel.response.Cancellation;

import java.io.Serializable;
import java.util.List;

/**
 * @author Brume
 **/
@Data
public class PreBookResponse implements Serializable {

    private ReturnStatus returnStatus;

    private String preBookingToken;

    private Integer currencyID;

    private Integer totalPrice;

    private Integer totalCommission;

    private String VATOnCommission;

    private List<Cancellation> cancellations;
}
