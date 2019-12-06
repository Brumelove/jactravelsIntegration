package org.javasoft.searchapi.booking_api.payload.jactravel.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Brume
 **/
@Data
@XmlRootElement(name = "Guest")
public class Guest {

    @XmlElement(name = "Type")
    private String type;

    @XmlElement(name = "Title")
    private String title;

    @XmlElement(name = "FirstName")
    private String firstName;

    @XmlElement(name = "LastName")
    private String lastName;

    @XmlElement(name = "Age")
    private Integer age;

    @XmlElement(name = "DateOfBirth")
    private String dateOfBirth;
}
