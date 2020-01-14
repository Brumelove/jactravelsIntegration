package com.travelbeta.jacktravels.service.cancel_api.payload.client;


import lombok.Data;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.response.ReturnStatus;

import java.io.Serializable;

/**
 * @author Brume
 **/
@Data
public class CancelResponse implements Serializable {

    private ReturnStatus returnStatus;
}
