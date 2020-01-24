/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelbeta.jactravel.service.book_search_api.payload.jactravel.response;


import com.travelbeta.jactravel.service.booking_api.payload.jactravel.request.Guest;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 * @author Brume
 */
@Data
@XmlRootElement(name = "Room")
public class Room {

    @XmlElement(name = "RoomType")
    private String roomType;

    @XmlElement(name = "RoomView")
    private String roomView;

    @XmlElement(name = "MealBasis")
    private String mealBasis;

    @XmlElement(name = "MealBasisID")
    private Integer mealBasisId;

    @XmlElement(name = "Adults")
    private Integer adults;

    @XmlElement(name = "Children")
    private Integer children;

    @XmlElement(name = "Infants")
    private Integer infants;

    @XmlElement(name = "Guest")
    @XmlElementWrapper(name = "Guests")
    private List<Guest> guests;


}
