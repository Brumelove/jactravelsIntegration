package com.travelbeta.jactravels.service.booking_api.payload.jactravel.response;


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
@XmlRootElement(name = "BookResponse")
public class BookHotelResponse implements Serializable {

    @XmlElement(name = "ReturnStatus")
    private ReturnStatus returnStatus;

    @XmlElement(name = "CurrencyID")
    private Integer currencyID;

    @XmlElement(name = "BookingReference")
    private String bookingReference;

    @XmlElement(name = "TradeReference")
    private String tradeReference;

    @XmlElement(name = "TotalPrice")
    private Double totalPrice;

    @XmlElement(name = "TotalCommission")
    private Double totalCommission;

    @XmlElement(name = "CustomerTotalPrice")
    private Double customerTotalPrice;

    @XmlElement(name = "PaymentDue")
    @XmlElementWrapper(name = "PaymentDues")
    private List<PaymentDue> paymentDue;

    @XmlElement(name = "PropertyBooking")
    @XmlElementWrapper(name = "PropertyBookings")
    private List<PropertyBooking> propertyBookings;
}
