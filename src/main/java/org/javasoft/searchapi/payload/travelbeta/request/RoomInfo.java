package org.javasoft.searchapi.payload.travelbeta.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

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
