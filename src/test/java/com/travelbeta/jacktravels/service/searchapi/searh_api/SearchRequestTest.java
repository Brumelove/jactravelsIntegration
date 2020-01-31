package com.travelbeta.jacktravels.service.searchapi.searh_api;

import lombok.val;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.request.RoomInfo;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.request.SearchDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brume
 **/
public class SearchRequestTest {

    public void setSearchDetails() {
        val searchDetails = new SearchDetails();

        List<RoomInfo> roomInfoList = new ArrayList<>();
        val roomInfo = new RoomInfo();

        roomInfo.setAdults(1);
        roomInfo.setChildren(0);
        roomInfo.setInfants(0);

        roomInfoList.add(roomInfo);

        searchDetails.setCheckInDate("9090-29-08");
        searchDetails.setMealBasisID(1);
        searchDetails.setRegionID(17);
        searchDetails.setRoomInfoList(roomInfoList);
    }

}
