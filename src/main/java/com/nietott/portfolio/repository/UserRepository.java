package com.nietott.portfolio.repository;

import org.springframework.stereotype.Repository;
import com.nietott.portfolio.model.Users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository <Users, Long>{
    Optional<Users> findByEmail(String email);
}
