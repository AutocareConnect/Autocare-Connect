package com.demo.service;

import java.util.List;

import com.demo.beans.Services;

public interface ServicesService {

	List<Services> getAllServices();

	List<Services> getServicesByServiceCenter(int serviceCenterId);

	void deleteService(int id);
	Services addService(Services services);

}
