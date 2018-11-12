package com.tracking_system.repository;

import com.tracking_system.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepo extends JpaRepository<Institution, Integer> {

    boolean existsByInstitutionId(Integer institutionId);
}
