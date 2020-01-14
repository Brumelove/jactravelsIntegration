package com.travelbeta.jacktravels.service.booking_api.payload.jactravel.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Brume
 **/
@Data
@XmlRootElement(name = "PaymentDue")
public class PaymentDue {

    @XmlElement(name = "PaymentDue")
    private Double paymentDue;

}
