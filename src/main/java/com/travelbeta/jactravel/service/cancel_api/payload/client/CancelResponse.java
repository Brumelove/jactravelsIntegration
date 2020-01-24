package com.travelbeta.jactravel.service.cancel_api.payload.client;


import lombok.Data;
import com.travelbeta.jactravel.service.search_api.payload.travelbeta.response.ReturnStatus;

import java.io.Serializable;

/**
 * @author Brume
 **/
@Data
public class CancelResponse implements Serializable {

    private ReturnStatus returnStatus;
}
