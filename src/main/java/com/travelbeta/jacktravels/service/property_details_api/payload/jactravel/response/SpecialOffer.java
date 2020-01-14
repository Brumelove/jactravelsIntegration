/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelbeta.jacktravels.service.property_details_api.payload.jactravel.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brume
 */
@XmlRootElement(name = "SpecialOffer")
public class SpecialOffer {

    @XmlElement(name = "ContractSpecialOfferID")
    private Integer contractSpecialOfferID;

    @XmlElement(name = "SpecialOfferTemplateID")
    private Integer specialOfferTemplateID;

    @XmlElement(name = "OfferName")
    private String offerName;

    @XmlElement(name = "OfferType")
    private String offerType;

    @XmlElement(name = "PropertyRoomType")
    private String propertyRoomType;

    @XmlElement(name = "MealBasis")
    private String mealBasis;

    @XmlElement(name = "Notes")
    private String notes;

    @XmlElement(name = "CustomerNote")
    private String customerNote;
}
