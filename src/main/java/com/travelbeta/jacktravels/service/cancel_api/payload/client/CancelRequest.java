package com.travelbeta.jacktravels.service.cancel_api.payload.client;


import lombok.Data;

/**
 * @author Brume
 **/

@Data
public class CancelRequest {
    private String bookingReference;
    private Double cancellationCost;
    private String cancellationToken;

}

