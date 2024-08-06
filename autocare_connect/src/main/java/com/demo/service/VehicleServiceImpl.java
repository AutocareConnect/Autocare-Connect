package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Vehicle;
import com.demo.dao.CustomerDao;
import com.demo.dao.VehicleDao;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleDao vdao;
	
	@Autowired
	private CustomerDao cdao;

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return vdao.save(vehicle);
	}

	@Override
	public Optional<Vehicle> getVehicleById(int id) {
		// TODO Auto-generated method stub
		return vdao.findById(id);
	}

	@Override
	public List<Vehicle> getVehiclesByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return vdao.findByCustomerCid(customerId);
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		// TODO Auto-generated method stub
		return vdao.findAll();
	}

	@Override
	public Vehicle updateVehicle(int id, Vehicle updatedVehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVehicle(int id) {
		// TODO Auto-generated method stub
		vdao.deleteById(id);
	}
}
