package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.beans.ServiceCenter;

public interface ServiceCenterService {

	ServiceCenter registerServiceCenter(ServiceCenter serviceCenter);

	ServiceCenter authenticateServiceCenter(String email, String password);

	ServiceCenter findByEmail(String email);

	List<ServiceCenter> findAllServiceCenters();

	Optional<ServiceCenter> findServiceCenterById(int id);

	ServiceCenter updateServiceCenter(int id, ServiceCenter updatedServiceCenter);

	void deleteServiceCenter(int id);
	

	
}
