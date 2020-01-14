package com.travelbeta.jacktravels.service.searchapi.service.db;

import com.travelbeta.jacktravels.service.searchapi.payload.client.SearchRequest;
import com.travelbeta.jacktravels.service.searchapi.payload.client.SearchResponse;
import com.travelbeta.jacktravels.service.searchapi.repository.LocationRepository;
import com.travelbeta.jacktravels.service.searchapi.util.MapperUtil;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * @author Brume
 **/
@Service
public class LocationDbService {
    private final LocationRepository locationRepository;
    private final MapperUtil mapperUtil;

    @Autowired
    public LocationDbService(LocationRepository locationRepository, MapperUtil mapperUtil) {
        this.locationRepository = locationRepository;
        this.mapperUtil = mapperUtil;
    }

    public SearchResponse findLocationByCountry(SearchRequest searchRequest) {
        val country = searchRequest.getCountry();
        val locationList = locationRepository.findLocation(country);
        if (locationList == null) {
            return null;
        }
        val searchResponse = new SearchResponse();
        val propertyResultList = locationList.stream()
                .map(mapperUtil.mapLocationPropertyResult)
                .collect(Collectors.toList());
        searchResponse.setPropertyResults(propertyResultList);

        return searchResponse;
    }
}
