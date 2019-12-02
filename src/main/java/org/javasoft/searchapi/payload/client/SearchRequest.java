package org.javasoft.searchapi.payload.client;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.javasoft.searchapi.payload.travelbeta.request.RoomInfo;

import java.util.List;

@ToString
@Getter
@Setter
public class SearchRequest {

    private String checkInDate;

    private Integer duration;

    private Integer regionID;

    private Integer mealBasisID;

    private Integer minStarRating;

    private List<RoomInfo> roomInfoList;
}
