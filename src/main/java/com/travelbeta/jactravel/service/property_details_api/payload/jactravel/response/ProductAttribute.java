/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelbeta.jactravel.service.property_details_api.payload.jactravel.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brume
 */
@XmlRootElement(name = "ProductAttribute")
@Data
public class ProductAttribute {

    @XmlElement(name = "ProductAttributeID")
    private Integer productAttributeID;

    @XmlElement(name = "ProductAttribute")
    private String productAttribute;
    

}
