package com.travelbeta.jactravels.service.search_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Data @EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "Hotel")
@AllArgsConstructor @NoArgsConstructor
public class HotelEntity extends AbstractPersistable<Long> {

    private String name;

    private String description;

    private Long rating;

    private String dinning;

    private String reservation_phone_number;

    private String website_address;

    private String check_in_time;

    private String check_out_time;

    //@Enumerated(EnumType.STRING)
    private String  propertyType; // HOTEL ,SPA_$_RESORT ,VILLA_$_APARTMENT , GUEST_HOUSE , CAMP , LODGES

    //@Enumerated(EnumType.STRING)
    private String reservationPolicy; // PLI_POLICY ,FREE_CANCELLATION ,PAY_AT_HOTEL

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private ImageEntity imageEntity;
}
