package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.beans.Vehicle;

public interface VehicleService {

	Vehicle addVehicle(Vehicle vehicle);

	Optional<Vehicle> getVehicleById(int id);

	List<Vehicle> getVehiclesByCustomerId(int customerId);

	List<Vehicle> getAllVehicles();

	Vehicle updateVehicle(int id, Vehicle updatedVehicle);

	void deleteVehicle(int id);

}
