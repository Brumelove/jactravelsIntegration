package com.travelbeta.jactravels.service.prebooking_api.payload.client;


import com.travelbeta.jactravels.service.search_api.payload.travelbeta.response.ReturnStatus;
import lombok.Data;
import com.travelbeta.jactravels.service.prebooking_api.payload.jactravel.response.Cancellation;

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
