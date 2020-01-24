package com.travelbeta.jactravel.service.search_api.payload.client;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.travelbeta.jactravel.service.search_api.payload.travelbeta.response.PropertyResult;
import java.util.List;

@ToString
@Getter
@Setter
public class SearchResponse {

    private Integer currencyID;

    private List<PropertyResult> propertyResults;
}
