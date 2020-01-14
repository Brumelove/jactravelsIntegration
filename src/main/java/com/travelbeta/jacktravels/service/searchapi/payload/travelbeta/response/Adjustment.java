/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brume
 */
@Data
@XmlRootElement(name = "Adjustment")
public class Adjustment {

    @XmlElement(name = "AdjustmentType")
    private String adjustmentType;

    @XmlElement(name = "AdjustmentName")
    private String adjustmentName;

    @XmlElement(name = "Total")
    private Double total;


}
