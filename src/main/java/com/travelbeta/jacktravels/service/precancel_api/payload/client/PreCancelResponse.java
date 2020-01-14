package com.travelbeta.jacktravels.service.precancel_api.payload.client;


import lombok.Data;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.response.ReturnStatus;

import java.io.Serializable;

/**
 * @author Brume
 **/
@Data
public class PreCancelResponse implements Serializable {

    private ReturnStatus returnStatus;

    private Integer currencyID;

    private String bookingReference;

    private Double cancellationCost;

    private String cancellationToken;
}
