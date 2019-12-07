package org.javasoft.searchapi.multi_book_search_api.payload.jactravel.response;

import org.javasoft.searchapi.payload.travelbeta.request.RoomInfo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Brume
 **/

@XmlRootElement(name = "Booking")
public class Booking implements Serializable {

    @XmlElement(name = "CurrencyID")
    private Integer currencyID;

    @XmlElement(name = "BookingReference")
    private String bookingReference;

    @XmlElement(name = "BookingStatus")
    private String bookingStatus;

    @XmlElement(name = "BookingComponentStatus")
    private String bookingComponentStatus;

    @XmlElement(name = "BookingDate")
    private Date bookingDate;

    @XmlElement(name = "TradeReference")
    private String tradeReference;

    @XmlElement(name = "CurrencyCode")
    private String currencyCode;

    @XmlElement(name = "TotalPrice")
    private Integer totalPrice;

    @XmlElement(name = "HotelName")
    private String hotelName;

    @XmlElement(name = "LeadGuestName")
    private String leadGuestName;

    @XmlElement(name = "DestinationResort")
    private String destinationResort;

    @XmlElement(name = "ArrivalDate")
    private Date arrivalDate;

    @XmlElement(name = "DepartureDate")
    private Date departureDate;

    @XmlElement(name = "Duration")
    private Integer duration;

    @XmlElement(name = "HotelAddress")
    private String hotelAddress;

    @XmlElement(name = "ContactTelephone")
    private String contactTelephone;

    @XmlElement(name = "CustomerTotalPrice")
    private Double customerTotalPrice;

    @XmlElement(name = "CustomerTotalCommission")
    private Double customerTotalCommission;

    @XmlElement(name = "CreditCard")
    private String creditCard;

    @XmlElement(name = "Room")
    @XmlElementWrapper(name = "Rooms")
    private List<RoomInfo> rooms;
}
