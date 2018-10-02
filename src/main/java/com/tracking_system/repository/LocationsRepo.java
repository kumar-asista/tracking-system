package com.tracking_system.repository;

import com.tracking_system.model.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepo extends JpaRepository<Locations, Integer> {
}
