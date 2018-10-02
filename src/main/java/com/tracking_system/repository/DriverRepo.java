package com.tracking_system.repository;

import com.tracking_system.model.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends JpaRepository<Drivers, Long> {

    boolean existsByDriverLicenseNo(Long driverLicenseNo);
}
