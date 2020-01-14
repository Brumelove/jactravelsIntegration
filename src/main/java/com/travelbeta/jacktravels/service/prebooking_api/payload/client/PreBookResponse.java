package com.travelbeta.jacktravels.service.prebooking_api.payload.client;


import lombok.Data;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.response.ReturnStatus;
import com.travelbeta.jacktravels.service.prebooking_api.payload.jactravel.response.Cancellation;

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
