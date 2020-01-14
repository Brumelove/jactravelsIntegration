package com.travelbeta.jacktravels.service.multi_book_search_api.payload.client;


import lombok.Data;

import java.util.Date;

/**
 * @author Brume
 **/

@Data
public class MultiBookSearchRequest {

    private Date bookingCreationStartDate;

    private Date bookingCreationEndDate;

    private boolean allComponents;
}

