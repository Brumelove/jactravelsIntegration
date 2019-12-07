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
@XmlRootElement(name = "ProductAttributeGroup")
public class ProductAttributeGroup {

    @XmlElement(name = "ProductAttributeGroupID")
    private Integer productAttributeGroupID;

    @XmlElement(name = "ProductAttributeGroup")
    private String productAttributeGroup;

    @XmlElement(name = "ProductAttribute")
    @XmlElementWrapper(name = "ProductAttributes")
    private List<ProductAttribute> productAttributes;

}
