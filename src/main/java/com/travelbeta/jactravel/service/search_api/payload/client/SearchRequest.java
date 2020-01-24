package com.travelbeta.jactravel.service.search_api.payload.client;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.travelbeta.jactravel.service.search_api.payload.travelbeta.request.RoomInfo;

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
