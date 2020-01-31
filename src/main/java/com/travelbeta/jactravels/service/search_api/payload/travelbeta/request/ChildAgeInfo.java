package com.travelbeta.jactravels.service.search_api.payload.travelbeta.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "ChildAge")
public class ChildAgeInfo {

    @XmlElement(name = "Age")
    private Integer age;
}
