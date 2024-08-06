package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.beans.Vehicle;

@Repository
public interface VehicleDao extends JpaRepository<Vehicle, Integer> {

	List<Vehicle> findByCustomerCid(int customerId);

}
