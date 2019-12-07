package org.javasoft.searchapi.multi_book_search_api.payload.client;


import lombok.Data;
import org.javasoft.searchapi.payload.travelbeta.request.LoginDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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

