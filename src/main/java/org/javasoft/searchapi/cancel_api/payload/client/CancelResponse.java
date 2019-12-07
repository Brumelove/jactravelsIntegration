package org.javasoft.searchapi.cancel_api.payload.client;


import lombok.Data;
import org.javasoft.searchapi.payload.travelbeta.response.ReturnStatus;

import java.io.Serializable;

/**
 * @author Brume
 **/
@Data
public class CancelResponse implements Serializable {

    private ReturnStatus returnStatus;
}
