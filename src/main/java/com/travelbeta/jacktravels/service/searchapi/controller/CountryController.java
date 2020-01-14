package com.travelbeta.jacktravels.service.searchapi.controller;

import com.travelbeta.jacktravels.service.exception.ErrorDTO;
import com.travelbeta.jacktravels.service.searchapi.facade.SearchFacade;
import com.travelbeta.jacktravels.service.searchapi.payload.client.SearchRequest;
import com.travelbeta.jacktravels.service.searchapi.payload.client.SearchResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Brume
 **/
@Slf4j
@RestController
public class CountryController {
    private final SearchFacade searchFacade;

    @Autowired
    public CountryController(SearchFacade searchFacade) {
        this.searchFacade = searchFacade;
    }

    @PostMapping( "/v1/search/country")
    @ApiOperation(value = "", notes = "Search Country API")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public SearchResponse handleCountry(@RequestBody @Valid SearchRequest searchRequest){
        return searchFacade.handleCountry(searchRequest);
    }
}
