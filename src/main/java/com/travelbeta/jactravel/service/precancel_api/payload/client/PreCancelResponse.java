package com.travelbeta.jactravel.service.precancel_api.payload.client;


import lombok.Data;
import com.travelbeta.jactravel.service.search_api.payload.travelbeta.response.ReturnStatus;

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
