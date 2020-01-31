/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelbeta.jactravels.service.book_search_api.payload.jactravel.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brume
 */
@Data
@XmlRootElement(name = "Property")
public class Property {

    @XmlElement(name = "PropertyBookingReference")
    private Integer propertyBookingReference;

    @XmlElement(name = "Duration")
    private Integer duration;

    @XmlElement(name = "ArrivalDate")
    private String arrivalDate;

    @XmlElement(name = "PropertyName")
    private String propertyName;

    @XmlElement(name = "Rating")
    private Double rating;

    @XmlElement(name = "Status")
    private String status;

    @XmlElement(name = "Country")
    private String country;

    @XmlElement(name = "Region")
    private String region;

    @XmlElement(name = "Resort")
    private String resort;

    @XmlElement(name = "HotelAddress")
    private String hotelAddress;


}
