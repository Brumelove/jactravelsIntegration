//package com.travelbeta.jacktravels.service.searchapi.entity;
//
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.jpa.domain.AbstractPersistable;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.math.BigInteger;
//
///**
// * @author Brume
// **/
//@Data @EqualsAndHashCode(callSuper = false)
//@Entity
//@Table(name = "location")
////@NamedQuery(name = "LocationEntity.findByCountry",
////        query = "select l from LocationEntity where l  ")
//public class LocationEntity extends AbstractPersistable<Long> implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String country;
//    private Integer region_id;
//    private String region;
//    private String resort_id;
//    private String resort;
//
//}
