package com.travelbeta.jactravels.service.prebooking_api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import com.travelbeta.jactravels.service.exception.ErrorDTO;
import com.travelbeta.jactravels.service.prebooking_api.facade.PreBookFacade;
import com.travelbeta.jactravels.service.prebooking_api.payload.client.PreBookRequest;
import com.travelbeta.jactravels.service.prebooking_api.payload.client.PreBookResponse;
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
public class PreBookController {

    private final PreBookFacade preBookFacade;

    @Autowired
    public PreBookController(PreBookFacade preBookFacade) {
        this.preBookFacade = preBookFacade;
    }

    @PostMapping("/v1/pre-book")
    @ApiOperation(value = "", notes = "PreBook API")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public PreBookResponse handlePreBook(@RequestBody @Valid PreBookRequest preBookRequest) {
        return preBookFacade.handlePreBook(preBookRequest);
    }
}
