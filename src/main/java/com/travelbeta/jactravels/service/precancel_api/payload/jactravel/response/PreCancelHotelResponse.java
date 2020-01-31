package com.travelbeta.jactravels.service.precancel_api.payload.jactravel.response;


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
public class PreCancelHotelResponse implements Serializable {

    @XmlElement(name = "ReturnStatus")
    private ReturnStatus returnStatus;

    @XmlElement(name = "CurrencyID")
    private Integer currencyID;

    @XmlElement(name = "BookingReference")
    private String bookingReference;

    @XmlElement(name = "CancellationCost")
    private Double cancellationCost;

    @XmlElement(name = "CancellationToken")
    private String cancellationToken;

}
