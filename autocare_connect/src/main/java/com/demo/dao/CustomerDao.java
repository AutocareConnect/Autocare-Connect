package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.beans.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	Customer findByEmailAndPassword(String email, String password);

	
}
