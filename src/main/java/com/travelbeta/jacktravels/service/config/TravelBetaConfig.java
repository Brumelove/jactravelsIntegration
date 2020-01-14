package com.travelbeta.jacktravels.service.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Configuration
@Validated
//@ConfigurationProperties(prefix = "spring.datasource")
@PropertySource("classpath:config/TravelBetaConfig-${spring.profiles.active}.yaml")
public class TravelBetaConfig {

    @NotBlank
    private String hostUrl;

    @NotBlank
    private String username ;

    @NotBlank
    private String password;

    @NotBlank
    private String baseUrl;

    private Long cacheExpiryHours;
}
