package com.travelbeta.jactravels.service.cancel_api.payload.jactravel.response;


import com.travelbeta.jactravels.service.search_api.payload.travelbeta.response.ReturnStatus;
import lombok.Data;

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
