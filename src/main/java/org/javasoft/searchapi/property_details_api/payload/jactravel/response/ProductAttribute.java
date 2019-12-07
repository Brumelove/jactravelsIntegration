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
@XmlRootElement(name = "ProductAttribute")
public class ProductAttribute {

    @XmlElement(name = "ProductAttributeID")
    private Integer productAttributeID;

    @XmlElement(name = "ProductAttribute")
    private String productAttribute;
    

}
