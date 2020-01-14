package com.travelbeta.jacktravels.service.precancel_api.payload.jactravel.response;


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
