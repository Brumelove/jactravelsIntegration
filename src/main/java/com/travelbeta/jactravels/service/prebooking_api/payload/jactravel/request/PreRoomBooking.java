package com.travelbeta.jactravels.service.prebooking_api.payload.jactravel.request;


import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Brume
 **/

@Data
@XmlRootElement(name = "RoomBooking")
public class PreRoomBooking {

    @XmlElement(name = "PropertyRoomTypeID")
    private Integer propertyRoomTypeID;

    @XmlElement(name = "BookingToken")
    private String bookingToken;

    @XmlElement(name = "MealBasisID")
    private Integer mealBasisID;

    @XmlElement(name = "Adults")
    private Integer adults;

    @XmlElement(name = "Children")
    private Integer children;

    @XmlElement(name = "Infants")
    private Integer infants;

//    @XmlElement(name = "ChildAge")
//    @XmlElementWrapper(name = "ChildAges")
//    private List<ChildAgeInfo> childAge;
}
