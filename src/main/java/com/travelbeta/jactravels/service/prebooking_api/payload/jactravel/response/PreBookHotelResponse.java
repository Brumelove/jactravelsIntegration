package com.travelbeta.jactravels.service.prebooking_api.payload.jactravel.response;


import com.travelbeta.jactravels.service.search_api.payload.travelbeta.response.ReturnStatus;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author Brume
 **/
@Data
@XmlRootElement(name = "4eBookResponse")
public class PreBookHotelResponse implements Serializable {

    @XmlElement(name = "ReturnStatus")
    private ReturnStatus returnStatus;

    @XmlElement(name = "PreBookingToken")
    private String preBookingToken;

    @XmlElement(name = "CurrencyID")
    private Integer currencyID;

    @XmlElement(name = "TotalPrice")
    private Integer totalPrice;

    @XmlElement(name = "TotalCommission")
    private Integer totalCommission;

    @XmlElement(name = "VATOnCommission")
    private String VATOnCommission;

    @XmlElement(name = "Cancellation")
    @XmlElementWrapper(name = "Cancellations")
    private List<Cancellation> cancellations;
}
