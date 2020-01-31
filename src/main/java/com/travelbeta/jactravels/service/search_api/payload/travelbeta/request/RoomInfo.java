package com.travelbeta.jactravels.service.search_api.payload.travelbeta.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "RoomRequest")
public class RoomInfo {

    @XmlElement(name = "Adults")
    private Integer adults;

    @XmlElement(name = "Children")
    private Integer children;

    @XmlElement(name = "Infants")
    private Integer infants;

//    @XmlElement(name = "ChildAge")
//    @XmlElementWrapper(name = "ChildAges")
//    private List<ChildAgeInfo> childAges;
}
