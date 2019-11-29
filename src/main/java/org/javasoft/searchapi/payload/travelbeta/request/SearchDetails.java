package org.javasoft.searchapi.payload.travelbeta.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Data
public class SearchDetails {

    @XmlElement(name = "ArrivalDate")
    private String checkInDate;

    @XmlElement(name = "Duration")
    private Integer duration;

    @XmlElement(name = "RegionID")
    private Integer regionID;

    @XmlElement(name = "MealBasisID")
    private Integer mealBasisID;

    @XmlElement(name = "MinStarRating")
    private Integer minStarRating;

    @XmlElement(name = "RoomRequest")
    @XmlElementWrapper(name = "RoomRequests")
    private List<RoomInfo> roomInfoList;
}
