package com.travelbeta.jacktravels.service.searchapi.service.db;

import lombok.val;
import com.travelbeta.jacktravels.service.searchapi.enums.PropertyTypeEnum;
import com.travelbeta.jacktravels.service.searchapi.payload.client.SearchRequest;
import com.travelbeta.jacktravels.service.searchapi.payload.client.SearchResponse;
import com.travelbeta.jacktravels.service.searchapi.repository.HotelRepository;
import com.travelbeta.jacktravels.service.searchapi.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class HotelDbService {

    private final HotelRepository hotelRepository;

    private final MapperUtil mapperUtil;

    @Autowired
    public HotelDbService(HotelRepository hotelRepository, MapperUtil mapperUtil) {
        this.hotelRepository = hotelRepository;
        this.mapperUtil = mapperUtil;
    }

    public SearchResponse findHotel(SearchRequest searchRequest){
        val checkInTime = searchRequest.getCheckInDate();
        val rating = Long.valueOf(searchRequest.getMinStarRating());
        val hotelList = hotelRepository.findHotels(checkInTime,rating, PropertyTypeEnum.HOTEL.name());
        if(hotelList.isEmpty()){
            return null;
        }
        val searchResponse = new SearchResponse();
        val propertyResultList = hotelList.stream()
                .map(mapperUtil.mapPropertyResult)
                .collect(Collectors.toList());
        searchResponse.setPropertyResults(propertyResultList);
        return searchResponse;
    }
}
