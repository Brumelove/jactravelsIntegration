/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelbeta.jactravels.service.property_details_api.payload.jactravel.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brume
 */
@XmlRootElement(name = "BedType")
@Data
public class BedType {

    @XmlElement(name = "BedType")
    private String bedType;


    
}
