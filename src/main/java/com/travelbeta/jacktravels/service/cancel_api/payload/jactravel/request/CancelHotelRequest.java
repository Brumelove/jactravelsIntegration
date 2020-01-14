package com.travelbeta.jacktravels.service.cancel_api.payload.jactravel.request;


import lombok.Data;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.request.LoginDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Brume
 **/

@Data
@XmlRootElement(name = "CancelRequest")
public class CancelHotelRequest {

    @XmlElement(name = "LoginDetails")
    private LoginDetails loginDetails;

    @XmlElement(name = "BookingReference")
    private String bookingReference;

    @XmlElement(name = "CancellationCost")
    private Double cancellationCost;

    @XmlElement(name = "CancellationToken")
    private String cancellationToken;
}

