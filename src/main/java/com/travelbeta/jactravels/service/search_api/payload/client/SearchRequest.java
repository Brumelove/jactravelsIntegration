package com.travelbeta.jactravels.service.search_api.payload.client;

import com.travelbeta.jactravels.service.search_api.payload.travelbeta.request.RoomInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
