package com.travelbeta.jactravels.service.search_api.payload.client;

import com.travelbeta.jactravels.service.search_api.payload.travelbeta.response.PropertyResult;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class SearchResponse {

    private Integer currencyID;

    private List<PropertyResult> propertyResults;
}
