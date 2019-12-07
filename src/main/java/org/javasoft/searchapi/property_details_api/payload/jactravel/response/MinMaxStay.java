/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.searchapi.property_details_api.payload.jactravel.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brume
 */
@XmlRootElement(name = "MinMaxStay")
public class MinMaxStay {

    @XmlElement(name = "PropertyRoomTypeID")
    private Integer propertyRoomTypeID;

    @XmlElement(name = "StartDate")
    private String startDate;

    @XmlElement(name = "EndDate")
    private String endDate;

    @XmlElement(name = "MinStay")
    private Integer minStay;

    @XmlElement(name = "MaxStay")
    private Integer maxStay;

    @XmlElement(name = "ArriveMon")
    private Boolean arriveMon;

    @XmlElement(name = "ArriveTue")
    private Boolean arriveTue;

    @XmlElement(name = "ArriveWed")
    private Boolean arriveWed;

    @XmlElement(name = "ArriveThu")
    private Boolean arriveThu;

    @XmlElement(name = "ArriveFri")
    private Boolean arriveFri;

    @XmlElement(name = "ArriveSat")
    private Boolean arriveSat;

    @XmlElement(name = "ArriveSun")
    private Boolean arriveSun;

    @XmlElement(name = "DepartMon")
    private Boolean departMon;

    @XmlElement(name = "DepartTue")
    private Boolean departTue;

    @XmlElement(name = "DepartWed")
    private Boolean departWed;

    @XmlElement(name = "DepartThu")
    private Boolean departThu;

    @XmlElement(name = "DepartFri")
    private Boolean departFri;

    @XmlElement(name = "DepartSat")
    private Boolean departSat;

    @XmlElement(name = "DepartSun")
    private Boolean departSun;
    
}
