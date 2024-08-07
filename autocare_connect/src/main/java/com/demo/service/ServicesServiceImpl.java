package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Services;
import com.demo.dao.ServicesDao;

@Service
public class ServicesServiceImpl implements ServicesService{

	@Autowired
	private ServicesDao sdao;

	@Override
	public List<Services> getAllServices() {
		// TODO Auto-generated method stub
		return sdao.findAll();
	}

	@Override
	public List<Services> getServicesByServiceCenter(int serviceCenterId) {
		// TODO Auto-generated method stub
		return sdao.findByServiceCenterId(serviceCenterId);
	}

	@Override
	public void deleteService(int id) {
		// TODO Auto-generated method stub
		sdao.deleteById(id);
	}

	@Override
	public Services addService(Services services) {
		// TODO Auto-generated method stub
		return sdao.save(services);
	}
}
