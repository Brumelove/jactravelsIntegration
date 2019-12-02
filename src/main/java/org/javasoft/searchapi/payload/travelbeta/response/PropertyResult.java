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
@XmlRootElement(name = "PropertyResult")
public class PropertyResult {

    @XmlElement(name = "TotalProperties")
    private Integer totalProperties;

    @XmlElement(name = "PropertyID")
    private Integer propertyID;

    @XmlElement(name = "PropertyReferenceID")
    private Integer propertyReferenceID;

    @XmlElement(name = "PropertyName")
    private String propertyName;

    @XmlElement(name = "Rating")
    private String rating;

    @XmlElement(name = "OurRating")
    private String ourRating;

    @XmlElement(name = "Country")
    private String country;

    @XmlElement(name = "Region")
    private String region;

    @XmlElement(name = "Resort")
    private String resort;

    @XmlElement(name = "RoomType")
    @XmlElementWrapper(name = "RoomTypes")
    private List<RoomType> roomTypes;
}
