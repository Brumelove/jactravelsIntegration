package org.javasoft.searchapi.prebooking_api.payload.jactravel.request;

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
public class PreBookingDetails {

    @XmlElement(name = "PropertyID")
    private Integer propertyID;

    @XmlElement(name = "ArrivalDate")
    private String arrivalDate;

    @XmlElement(name = "Duration")
    private Integer duration;

    @XmlElement(name = "RoomBooking")
    @XmlElementWrapper(name = "RoomBookings")
    private List<PreRoomBooking> preRoomBookings;

}