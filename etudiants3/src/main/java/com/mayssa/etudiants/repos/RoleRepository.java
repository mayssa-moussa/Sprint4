package com.mayssa.etudiants.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayssa.etudiants.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRole(String role);
}
