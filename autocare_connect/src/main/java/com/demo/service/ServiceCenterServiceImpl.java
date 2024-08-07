package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.ServiceCenter;
import com.demo.dao.ServiceCenterDao;

@Service
public class ServiceCenterServiceImpl implements ServiceCenterService{

	@Autowired
	private ServiceCenterDao sdao;

	@Override
	public ServiceCenter registerServiceCenter(ServiceCenter serviceCenter) {
		// TODO Auto-generated method stub
		return sdao.save(serviceCenter);
	}

	@Override
	public ServiceCenter authenticateServiceCenter(String email, String password) {
		// TODO Auto-generated method stub
		return sdao.findByEmailAndPassword(email, password);
	}

	@Override
	public ServiceCenter findByEmail(String email) {
		// TODO Auto-generated method stub
		return sdao.findByEmail(email);
	}

	@Override
	public List<ServiceCenter> findAllServiceCenters() {
		// TODO Auto-generated method stub
		return sdao.findAll();
	}

	@Override
	public Optional<ServiceCenter> findServiceCenterById(int id) {
		// TODO Auto-generated method stub
		return sdao.findById(id);
	}

	@Override
	public ServiceCenter updateServiceCenter(int id, ServiceCenter updatedServiceCenter) {
		Optional<ServiceCenter> existingServiceCenterOpt = sdao.findById(id);

        if (existingServiceCenterOpt.isPresent()) {
            ServiceCenter existingServiceCenter = existingServiceCenterOpt.get();
            existingServiceCenter.setName(updatedServiceCenter.getName());
            existingServiceCenter.setEmail(updatedServiceCenter.getEmail());
            existingServiceCenter.setPassword(updatedServiceCenter.getPassword()); // Ensure password is hashed
            existingServiceCenter.setPhone(updatedServiceCenter.getPhone());
            existingServiceCenter.setAddress(updatedServiceCenter.getAddress());
            existingServiceCenter.setPincode(updatedServiceCenter.getPincode());
            existingServiceCenter.setWorkingHours(updatedServiceCenter.getClosedDays());
            existingServiceCenter.setClosedDays(updatedServiceCenter.getClosedDays());
            return sdao.save(existingServiceCenter);
        } else {
            updatedServiceCenter.setCid(id);
            return sdao.save(updatedServiceCenter);
        }
	}

	@Override
	public void deleteServiceCenter(int id) {
		// TODO Auto-generated method stub
		sdao.deleteById(id);
	}
	
	
}
