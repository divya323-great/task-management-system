package com.divya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.divya.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}