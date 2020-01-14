package com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@ToString
@Getter
@Setter
@XmlRootElement(name = "SearchRequest")
public class SearchHotelRequest {

    @XmlElement(name = "LoginDetails")
    private LoginDetails loginDetails;

    @XmlElement(name = "SearchDetails")
    private SearchDetails searchDetails;
}
