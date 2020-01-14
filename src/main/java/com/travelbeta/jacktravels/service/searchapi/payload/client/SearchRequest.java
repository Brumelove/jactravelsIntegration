package com.travelbeta.jacktravels.service.searchapi.payload.client;

import lombok.Data;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.request.RoomInfo;

import java.util.List;

@Data
public class SearchRequest {

    private String checkInDate;

    private Integer duration;

    private Integer regionID;

    private String country;

    private Integer mealBasisID;

    private Integer minStarRating;

    private List<RoomInfo> roomInfoList;
}
