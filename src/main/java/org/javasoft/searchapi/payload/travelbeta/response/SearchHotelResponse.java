package org.javasoft.searchapi.payload.travelbeta.response;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@ToString
@Getter
@Setter
@XmlRootElement(name = "SearchResponse")
public class SearchHotelResponse {

    @XmlElement(name = "ReturnStatus")
    private ReturnStatus returnStatus;

    @XmlElement(name = "CurrencyID")
    private Integer currencyID;

    @XmlElement(name = "PropertyResult")
    @XmlElementWrapper(name = "PropertyResults")
    private List<PropertyResult> propertyResults;
}
