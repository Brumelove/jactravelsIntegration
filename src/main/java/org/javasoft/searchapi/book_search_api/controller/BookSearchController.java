package org.javasoft.searchapi.book_search_api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.javasoft.searchapi.exception.ErrorDTO;
import org.javasoft.searchapi.book_search_api.facade.BookSearchFacade;
import org.javasoft.searchapi.book_search_api.payload.client.BookSearchRequest;
import org.javasoft.searchapi.book_search_api.payload.client.BookSearchResponse;
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
public class BookSearchController {

    private final BookSearchFacade bookSearchFacade;

    @Autowired
    public BookSearchController(BookSearchFacade bookSearchFacade) {
        this.bookSearchFacade = bookSearchFacade;
    }

    @PostMapping("/v1/book-search")
    @ApiOperation(value = "", notes = "PreBook API")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public BookSearchResponse handleMultiBookSearch(@RequestBody @Valid BookSearchRequest bookSearchRequest) {
        return bookSearchFacade.handleMultiBookSearch(bookSearchRequest);
    }
}
