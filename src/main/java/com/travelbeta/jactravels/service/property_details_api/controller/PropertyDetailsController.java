package com.travelbeta.jactravels.service.property_details_api.controller;

import com.travelbeta.jactravels.service.property_details_api.facade.PropertyDetailsFacade;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import com.travelbeta.jactravels.service.exception.ErrorDTO;
import com.travelbeta.jactravels.service.property_details_api.payload.client.PropertyDetailsRequest;
import com.travelbeta.jactravels.service.property_details_api.payload.client.PropertyDetailsResponse;
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
public class PropertyDetailsController {

    private final PropertyDetailsFacade propertyDetailsFacade;

    @Autowired
    public PropertyDetailsController(PropertyDetailsFacade propertyDetailsFacade) {
        this.propertyDetailsFacade = propertyDetailsFacade;
    }

    @PostMapping("/v1/property-details")
    @ApiOperation(value = "", notes = "Property details API")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public PropertyDetailsResponse handlePropertyDetails(@RequestBody @Valid PropertyDetailsRequest propertyDetailsRequest) {
        return propertyDetailsFacade.handlePropertyDetailsResponse(propertyDetailsRequest);
    }
}
