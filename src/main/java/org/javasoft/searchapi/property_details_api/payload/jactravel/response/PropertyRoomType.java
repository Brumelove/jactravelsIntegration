/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.searchapi.property_details_api.payload.jactravel.response;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brume
 */
@XmlRootElement(name = "PropertyRoomType")
public class PropertyRoomType {

    @XmlElement(name = "PropertyRoomTypeID")
    private Integer propertyRoomTypeID;

    @XmlElement(name = "RoomType")
    private String roomType;

    @XmlElement(name = "RoomView")
    private String roomView;

    @XmlElement(name = "DefaultMealBasis")
    private String defaultMealBasis;

    @XmlElement(name = "BedType")
    @XmlElementWrapper(name = "BedTypes")
    private List<BedType> bedTypes;

    @XmlElement(name = "Facility")
    @XmlElementWrapper(name = "Facilities")
    private List<Facility> facilities;

}
