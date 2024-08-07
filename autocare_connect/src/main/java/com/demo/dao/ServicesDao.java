package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.beans.Services;

@Repository
public interface ServicesDao extends JpaRepository<Services, Integer>{

	List<Services> findByServiceCenterCid(int serviceCenterCid);

}
