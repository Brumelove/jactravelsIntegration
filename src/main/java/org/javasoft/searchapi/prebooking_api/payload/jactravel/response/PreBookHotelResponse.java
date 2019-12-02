package org.javasoft.searchapi.prebooking_api.payload.jactravel.response;


import lombok.Data;
import org.javasoft.searchapi.payload.travelbeta.response.ReturnStatus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author Brume
 **/
@Data
@XmlRootElement(name = "PreBookResponse")
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
    private Integer VATOnCommission;

    @XmlElement(name = "Cancellation")
    @XmlElementWrapper(name = "Cancellations")
    private List<Cancellation> cancellations;
}
