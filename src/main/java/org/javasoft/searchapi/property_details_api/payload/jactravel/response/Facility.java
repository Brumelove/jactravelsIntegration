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
@XmlRootElement(name = "Facility")
public class Facility {

    @XmlElement(name = "FacilityType")
    private String facilityType;

    @XmlElement(name = "FacilityID")
    private Integer facilityID;

    @XmlElement(name = "FacilityGroup")
    private String facilityGroup;

    @XmlElement(name = "Facility")
    private String facility;

    @XmlElement(name = "Notes")
    private String notes;

    @XmlElement(name = "CostInformation")
    private Integer costInformation;

}
