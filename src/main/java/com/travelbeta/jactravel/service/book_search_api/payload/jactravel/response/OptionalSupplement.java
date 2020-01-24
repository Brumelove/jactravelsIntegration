/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelbeta.jactravel.service.book_search_api.payload.jactravel.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brume
 */
@Data
@XmlRootElement(name = "OptionalSupplement")
public class OptionalSupplement {

    @XmlElement(name = "ContractSupplementID")
    private Integer contractSupplementID;

    @XmlElement(name = "Supplement")
    private String supplement;

    @XmlElement(name = "Description")
    private String description;


}
