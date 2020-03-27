package com.travelbeta.jactravels.service.search_api.controller;

import com.travelbeta.jactravels.service.exception.ErrorDTO;
import com.travelbeta.jactravels.service.search_api.facade.SearchFacade;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import com.travelbeta.jactravels.service.search_api.payload.client.SearchRequest;
import com.travelbeta.jactravels.service.search_api.payload.client.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(maxAge = 3600)
@Slf4j
@RestController
public class SearchController {

    private final SearchFacade searchFacade;

    @Autowired
    public SearchController(SearchFacade searchFacade) {
        this.searchFacade = searchFacade;
    }


    @PostMapping( "/v1/search")
    @ApiOperation(value = "", notes = "Search API")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public SearchResponse handleSearch(@RequestBody @Valid  SearchRequest searchRequest){
        return searchFacade.handleSearch(searchRequest);
    }
}
