package org.javasoft.searchapi.payload.client;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.javasoft.searchapi.payload.travelbeta.response.PropertyResult;
import java.util.List;

@ToString
@Getter
@Setter
public class SearchResponse {

    private Integer currencyID;

    private List<PropertyResult> propertyResults;
}
