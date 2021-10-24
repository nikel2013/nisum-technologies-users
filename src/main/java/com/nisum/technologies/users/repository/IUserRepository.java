package com.nisum.technologies.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nisum.technologies.users.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

	Boolean existsByEmail(String email);
	
}