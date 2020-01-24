package com.travelbeta.jactravel.service.book_search_api.payload.jactravel.response;


import lombok.Data;
import com.travelbeta.jactravel.service.search_api.payload.travelbeta.response.ReturnStatus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author Brume
 **/
@Data
@XmlRootElement(name = "BookingResponse")
public class BookSearchHotelResponse implements Serializable {

    @XmlElement(name = "ReturnStatus")
    private ReturnStatus returnStatus;

    @XmlElement(name = "CurrencyID")
    private Integer currencyID;

    @XmlElement(name = "BookingReference")
    private String bookingReference;

    @XmlElement(name = "Status")
    private String status;

    @XmlElement(name = "AccountStatus")
    private String accountStatus;

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

    @XmlElement(name = "TotalPrice")
    private Double totalPrice;

    @XmlElement(name = "TotalOutstanding")
    private Double totalOutstanding;

    @XmlElement(name = "TotalCommission")
    private Double totalCommission;

    @XmlElement(name = "Property")
    @XmlElementWrapper(name = "Properties")
    private List<Property> properties;

    @XmlElement(name = "Room")
    @XmlElementWrapper(name = "Rooms")
    private List<Room> rooms;

    @XmlElement(name = "Adjustment")
    @XmlElementWrapper(name = "Adjustments")
    private List<Adjustment> adjustments;

    @XmlElement(name = "OptionalSupplement")
    @XmlElementWrapper(name = "OptionalSupplements")
    private List<OptionalSupplement> optionalSupplements;

    @XmlElement(name = "Erratum")
    @XmlElementWrapper(name = "Errata")
    private List<Erratum> errata;

    @XmlElement(name = "Comment")
    @XmlElementWrapper(name = "Comments")
    private List<Comment> comments;
}
