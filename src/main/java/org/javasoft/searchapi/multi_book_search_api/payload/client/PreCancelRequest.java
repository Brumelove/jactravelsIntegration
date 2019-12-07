package org.javasoft.searchapi.multi_book_search_api.payload.client;


import lombok.Data;

/**
 * @author Brume
 **/

@Data
public class PreCancelRequest {
    private String bookingReference;
}

