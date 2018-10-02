package com.tracking_system.repository;

import com.tracking_system.model.Root;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RootRepo extends JpaRepository<Root, Integer> {

    boolean existsByRootId(Integer rootid);
}
