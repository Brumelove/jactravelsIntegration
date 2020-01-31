package com.travelbeta.jactravels.service.search_api.payload.travelbeta.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter
@Setter
@XmlRootElement(name = "LoginDetails")
public class LoginDetails {

    @XmlElement(name = "Login")
    private String login;

    @XmlElement(name = "Password")
    private String password;

    @XmlElement(name = "Locale")
    private String locale;

    @XmlElement(name = "CurrencyID")
    private Integer currencyID;

    @XmlElement(name = "AgentReference")
    private String agentReference;
}
