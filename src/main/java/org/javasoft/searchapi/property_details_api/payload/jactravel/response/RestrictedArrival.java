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
@XmlRootElement(name = "RestrictedArrival")
public class RestrictedArrival {

    @XmlElement(name = "StartDate")
    private String startDate;

    @XmlElement(name = "EndDate")
    private String endDate;

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
    
}
