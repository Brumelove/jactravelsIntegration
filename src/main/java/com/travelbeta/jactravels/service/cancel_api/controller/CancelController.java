package com.travelbeta.jactravels.service.cancel_api.controller;

import com.travelbeta.jactravels.service.cancel_api.facade.CancelFacade;
import com.travelbeta.jactravels.service.cancel_api.payload.client.CancelRequest;
import com.travelbeta.jactravels.service.cancel_api.payload.client.CancelResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import com.travelbeta.jactravels.service.exception.ErrorDTO;
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
public class CancelController {

    private final CancelFacade cancelFacade;

    @Autowired
    public CancelController(CancelFacade cancelFacade) {
        this.cancelFacade = cancelFacade;
    }

    @PostMapping("/v1/cancel")
    @ApiOperation(value = "", notes = "PreBook API")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public CancelResponse handleCancel(@RequestBody @Valid CancelRequest cancelRequest) {
        return cancelFacade.handleCancel(cancelRequest);
    }
}
