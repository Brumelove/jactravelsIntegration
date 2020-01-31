package com.travelbeta.jactravels.service.precancel_api.payload.client;


import com.travelbeta.jactravels.service.search_api.payload.travelbeta.response.ReturnStatus;
import lombok.Data;

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
