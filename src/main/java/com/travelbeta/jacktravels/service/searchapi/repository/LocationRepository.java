package com.travelbeta.jacktravels.service.searchapi.repository;

import com.travelbeta.jacktravels.service.searchapi.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Brume
 **/
@Repository
public interface LocationRepository extends JpaRepository<LocationEntity,String> {

    @Query(value = "Select l from LocationEntity l where l.country=:country " +
            "and l.region = :region" )
    List<LocationEntity> findLocation(@Param("country") String country,
                                      @Param("region") String region);
}
