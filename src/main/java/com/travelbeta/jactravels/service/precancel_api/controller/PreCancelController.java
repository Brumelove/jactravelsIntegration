package com.travelbeta.jactravels.service.precancel_api.controller;

import com.travelbeta.jactravels.service.exception.ErrorDTO;
import com.travelbeta.jactravels.service.precancel_api.facade.PreCancelFacade;
import com.travelbeta.jactravels.service.precancel_api.payload.client.PreCancelRequest;
import com.travelbeta.jactravels.service.precancel_api.payload.client.PreCancelResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Brume
 **/

@CrossOrigin(maxAge = 3600)
@Slf4j
@RestController
public class PreCancelController {

    private final PreCancelFacade preCancelFacade;

    @Autowired
    public PreCancelController(PreCancelFacade preCancelFacade) {
        this.preCancelFacade = preCancelFacade;
    }

    @PostMapping("/v1/pre-cancel")
    @ApiOperation(value = "", notes = "PreBook API")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public PreCancelResponse handlePreCancel(@RequestBody @Valid PreCancelRequest preCancelRequest) {
        return preCancelFacade.handlePreCancel(preCancelRequest);
    }
}
