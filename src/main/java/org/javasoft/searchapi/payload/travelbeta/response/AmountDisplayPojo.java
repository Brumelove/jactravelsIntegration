/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.searchapi.payload.travelbeta.response;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author Brume
 */
@Data
public class AmountDisplayPojo implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long amount;
    private String formattedAmount;
    private String htmlCurrencySymbol;
    private Long margin;
    private Long supplierPrice;

}
