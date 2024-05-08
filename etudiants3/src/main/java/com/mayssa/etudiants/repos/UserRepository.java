package com.mayssa.etudiants.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayssa.etudiants.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername (String username);
}
