package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.beans.UserRole;

@Repository
public interface UserRoleDao extends JpaRepository<UserRole, Integer>{

	UserRole findByEmailAndPassword(String email, String password);

	UserRole findByEmail(String username);

}
