package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.beans.ServiceCenter;

@Repository
public interface ServiceCenterDao extends JpaRepository<ServiceCenter, Integer>{

	ServiceCenter findByEmailAndPassword(String email, String password);

	ServiceCenter findByEmail(String email);

}
