package com.tracking_system.repository;

import com.tracking_system.model.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationsRepo extends JpaRepository<Locations, Integer> {

    @Query(value = "select * from locations where root_id= ?1 order by created_at desc limit 1", nativeQuery = true  )
    Locations findLocationByRoot(Integer rootid);
}
