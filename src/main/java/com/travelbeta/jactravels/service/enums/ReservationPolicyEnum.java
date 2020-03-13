package com.travelbeta.jactravels.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
@AllArgsConstructor
public enum ReservationPolicyEnum {

    PLI_POLICY("PLI_POLICY"),

    FREE_CANCELLATION("FREE_CANCELLATION"),

    PAY_AT_HOTEL("PAY_AT_HOTEL");

    @Getter
    private String reservationPolicy;

    public static ReservationPolicyEnum getReservationPolicyEnum(String reservationPolicy){
        return Stream.of(ReservationPolicyEnum.values())
                .filter(reservationPolicyEnum -> reservationPolicyEnum.getReservationPolicy().equalsIgnoreCase(reservationPolicy))
                .findFirst()
                .get();
    }
}
