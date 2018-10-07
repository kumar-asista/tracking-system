package com.tracking_system.repository;

import com.tracking_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Boolean existsByPhoneNo(Long phoneNo);
}
