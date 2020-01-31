package com.travelbeta.jactravels.service.multi_book_search_api.controller;

import com.travelbeta.jactravels.service.multi_book_search_api.facade.MultiBookSearchFacade;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import com.travelbeta.jactravels.service.exception.ErrorDTO;
import com.travelbeta.jactravels.service.multi_book_search_api.payload.client.MultiBookSearchRequest;
import com.travelbeta.jactravels.service.multi_book_search_api.payload.client.MultiBookSearchResponse;
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
public class MultiBookSearchController {

    private final MultiBookSearchFacade multiBookSearchFacade;

    @Autowired
    public MultiBookSearchController(MultiBookSearchFacade multiBookSearchFacade) {
        this.multiBookSearchFacade = multiBookSearchFacade;
    }

    @PostMapping("/v1/multi-book-search")
    @ApiOperation(value = "", notes = "PreBook API")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public MultiBookSearchResponse handleMultiBookSearch(@RequestBody @Valid MultiBookSearchRequest multiBookSearchRequest) {
        return multiBookSearchFacade.handleMultiBookSearch(multiBookSearchRequest);
    }
}
