package org.javasoft.searchapi.booking_api.payload.jactravel.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Brume
 **/

@Data
@XmlRootElement(name = "PropertyBooking")
public class PropertyBooking {

    @XmlElement(name = "PropertyBookingReference")
    private String propertyBookingReference;

    @XmlElement(name = "Supplier")
    private String supplier;

    @XmlElement(name = "SupplierReference")
    private String supplierReference;
}
