package com.tracking_system.repository;

import com.tracking_system.model.Bus;
import com.tracking_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusRepo extends JpaRepository<Bus, Long> {

    boolean existsByBusNo(Long busNo);
}
