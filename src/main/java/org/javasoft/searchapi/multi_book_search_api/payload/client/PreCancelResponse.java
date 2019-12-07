package org.javasoft.searchapi.multi_book_search_api.payload.client;


import lombok.Data;
import org.javasoft.searchapi.payload.travelbeta.response.ReturnStatus;

import java.io.Serializable;

/**
 * @author Brume
 **/
@Data
public class PreCancelResponse implements Serializable {

    private ReturnStatus returnStatus;

    private Integer currencyID;

    private String bookingReference;

    private Double cancellationCost;

    private String cancellationToken;
}
