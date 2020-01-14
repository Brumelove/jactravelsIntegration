package com.travelbeta.jacktravels.service.searchapi.payload.client;

import com.travelbeta.jacktravels.service.searchapi.service.db.HotelDbService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.travelbeta.jacktravels.service.searchapi.payload.travelbeta.response.PropertyResult;
import java.util.List;
import java.util.concurrent.Callable;

@ToString
@Getter
@Setter
public class SearchResponse  {

    private Integer currencyID;

    private List<PropertyResult> propertyResults;


}
