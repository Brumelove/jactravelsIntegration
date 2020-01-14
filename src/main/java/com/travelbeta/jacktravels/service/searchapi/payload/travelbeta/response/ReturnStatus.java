package com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter
@Setter
@XmlRootElement(name = "ReturnStatus")
public class ReturnStatus {

    @XmlElement(name = "Success")
    private boolean success;

    @XmlElement(name = "Exception")
    private String exception;
}
