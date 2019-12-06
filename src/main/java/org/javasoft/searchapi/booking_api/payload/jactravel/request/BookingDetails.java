package org.javasoft.searchapi.booking_api.payload.jactravel.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Brume
 **/

@Data

@XmlRootElement(name = "BookingDetails")
public class BookingDetails {

    @XmlElement(name = "PropertyID")
    private Integer propertyID;

    @XmlElement(name = "ArrivalDate")
    private String arrivalDate;

    @XmlElement(name = "Duration")
    private Integer duration;

    @XmlElement(name = "RoomBooking")
    @XmlElementWrapper(name = "RoomBookings")
    private List<RoomBooking> roomBookings;

    @XmlElement(name = "PreBookingToken")
    private String preBookingToken;

    @XmlElement(name = "LeadGuestTitle")
    private String leadGuestTitle;

    @XmlElement(name = "LeadGuestFirstName")
    private String leadGuestFirstName;

    @XmlElement(name = "LeadGuestLastName")
    private String leadGuestLastName;

    @XmlElement(name = "LeadGuestAddress1")
    private String leadGuestAddress1;

    @XmlElement(name = "LeadGuestAddress2")
    private String leadGuestAddress2;

    @XmlElement(name = "LeadGuestTownCity")
    private String leadGuestTownCity;

    @XmlElement(name = "LeadGuestCounty")
    private String leadGuestCounty;

    @XmlElement(name = "LeadGuestPostCode")
    private String leadGuestPostCode;

    @XmlElement(name = "LeadGuestBookingCountryID")
    private Integer leadGuestBookingCountryID;

    @XmlElement(name = "LeadGuestPhone")
    private String leadGuestPhone;

    @XmlElement(name = "LeadGuestFax")
    private String leadGuestFax;

    @XmlElement(name = "LeadGuestEmail")
    private String leadGuestEmail;

    @XmlElement(name = "Request")
    private String request;

    @XmlElement(name = "TradeReference")
    private String tradeReference;

}