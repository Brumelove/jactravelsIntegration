package org.javasoft.searchapi.booking_api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.javasoft.searchapi.booking_api.facade.BookFacade;
import org.javasoft.searchapi.booking_api.payload.client.BookRequest;
import org.javasoft.searchapi.booking_api.payload.client.BookResponse;
import org.javasoft.searchapi.exception.ErrorDTO;
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
