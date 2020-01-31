package com.travelbeta.jactravels.service.cancel_api.payload.client;


import com.travelbeta.jactravels.service.search_api.payload.travelbeta.response.ReturnStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Brume
 **/
@Data
public class CancelResponse implements Serializable {

    private ReturnStatus returnStatus;
}
