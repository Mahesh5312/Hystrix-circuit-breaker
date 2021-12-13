package com.travel.microservices.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.microservices.user.model.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
