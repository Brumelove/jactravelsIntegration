/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelbeta.jactravel.service.search_api.payload.travelbeta.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brume
 */
@Data
@XmlRootElement(name = "Erratum")
public class Erratum {

    @XmlElement(name = "Subject")
    private String subject;

    @XmlElement(name = "Description")
    private String description;

}
