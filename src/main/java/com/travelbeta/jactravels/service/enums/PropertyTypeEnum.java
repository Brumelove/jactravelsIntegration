package com.travelbeta.jactravels.service.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
@AllArgsConstructor
public enum PropertyTypeEnum {

    HOTEL("HOTEL"),

    SPA_$_RESORT("SPA_$_RESORT"),

    VILLA_$_APARTMENT("VILLA_$_APARTMENT"),

    GUEST_HOUSE("GUEST_HOUSE"),

    CAMP("CAMP"),

    LODGES("LODGES");

    @Getter
    private String propertyType;

    public static PropertyTypeEnum getPropertyTypeEnum(String propertyType){
        return Stream.of(PropertyTypeEnum.values())
                .filter(propertyTypeEnum -> propertyTypeEnum.getPropertyType().equalsIgnoreCase(propertyType))
                .findFirst()
                .get();
    }

}
