package com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "RoomType")
public class RoomType {

    @XmlElement(name = "Seq")
    private Integer seq;

    @XmlElement(name = "PropertyRoomTypeID")
    private Integer propertyRoomTypeID;

    @XmlElement(name = "BookingToken")
    private String bookingToken;

    @XmlElement(name = "MealBasisID")
    private Integer mealBasisID;

    @XmlElement(name = "RoomType")
    private String roomType;

    @XmlElement(name = "RoomView")
    private String roomView;

    @XmlElement(name = "MealBasis")
    private String mealBasis;

    @XmlElement(name = "SubTotal")
    private Double subTotal;

    @XmlElement(name = "Discount")
    private Double discount;

    @XmlElement(name = "SpecialOfferApplied")
    private String specialOfferApplied;

    @XmlElement(name = "OnRequest")
    private boolean onRequest;

    @XmlElement(name = "Total")
    private Double total;

    @XmlElement(name = "Commission")
    private Integer commission;

    @XmlElement(name = "RSP")
    private Double RSP;

    @XmlElement(name = "Adults")
    private Integer adults;

    @XmlElement(name = "Infants")
    private Integer infants;

    @XmlElement(name = "Children")
    private Integer children;

    @XmlElement(name = "Adjustment")
    @XmlElementWrapper(name = "Adjustments")
    private List<Adjustment> adjustments;

    @XmlElement(name = "Erratum")
    @XmlElementWrapper(name = "Errata")
    private List<Erratum> errata;

    @XmlElement(name = "Cancellation")
    @XmlElementWrapper(name = "Cancellations")
    private List<Cancellation> cancellations;

    private AmountDisplayPojo minAmount;

    private Boolean selected = false;
}
