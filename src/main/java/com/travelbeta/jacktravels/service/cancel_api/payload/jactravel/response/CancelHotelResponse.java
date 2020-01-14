package com.travelbeta.jacktravels.service.cancel_api.payload.jactravel.response;


import lombok.Data;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.response.ReturnStatus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Brume
 **/
@Data
@XmlRootElement(name = "PreCancelResponse")
public class CancelHotelResponse implements Serializable {

    @XmlElement(name = "ReturnStatus")
    private ReturnStatus returnStatus;

}
