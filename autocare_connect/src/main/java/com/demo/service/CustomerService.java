package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.beans.Customer;

public interface CustomerService {

	Customer registerCustomer(Customer customer);

	Customer authenticateCustomer(String email, String password);

	List<Customer> findAllCustomers();

	Optional<Customer> findCustomerById(int id);

	void deleteCustomer(int id);

}
