package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Customer;
import com.demo.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao cdao;

	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return cdao.save(customer);
	}

	@Override
	public Customer authenticateCustomer(String email, String password) {
		// TODO Auto-generated method stub
		return cdao.findByEmailAndPassword(email,password);
	}

	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}

	@Override
	public Optional<Customer> findCustomerById(int id) {
		// TODO Auto-generated method stub
		return cdao.findById(id);
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		cdao.deleteById(id);
	}
}
