package com.travelbeta.jacktravels.service.searchapi.repository;

import com.travelbeta.jacktravels.service.searchapi.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity,Long> {

    @Query(value = "Select h from HotelEntity h where h.check_in_time =:checkInTime " +
            " and h.rating >=:rating and h.propertyType =:propertyType ")
    List<HotelEntity> findHotels(@Param("checkInTime")String checkInTime,
                                 @Param("rating") Long rating,
                                 @Param("propertyType") String propertyType);



//    List<Country> findByCountryContainingIgnoreCase(String country)
}
