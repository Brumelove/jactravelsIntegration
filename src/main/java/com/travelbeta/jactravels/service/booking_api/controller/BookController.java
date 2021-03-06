package com.travelbeta.jactravels.service.booking_api.controller;

import com.travelbeta.jactravels.service.booking_api.facade.BookFacade;
import com.travelbeta.jactravels.service.booking_api.payload.client.BookRequest;
import com.travelbeta.jactravels.service.booking_api.payload.client.BookResponse;
import com.travelbeta.jactravels.service.exception.ErrorDTO;
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
public class BookController {

    private final BookFacade bookFacade;

    @Autowired
    public BookController(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @PostMapping("/v1/book")
    @ApiOperation(value = "", notes = "Book API")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse handleBook(@RequestBody @Valid BookRequest bookRequest) {
        return bookFacade.handlePreBook(bookRequest);
    }
}
