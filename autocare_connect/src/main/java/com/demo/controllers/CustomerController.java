package com.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Customer;
import com.demo.beans.UserRole;
import com.demo.service.CustomerService;
import com.demo.service.UserRoleService;



@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerService cservice;
	
	@Autowired
	private UserRoleService urService;
	
	 @PostMapping("/register")
	    public ResponseEntity<?> register(@RequestBody Customer customer) {
	        Customer registeredCustomer = cservice.registerCustomer(customer);
	        UserRole userRole = new UserRole(customer.getEmail(),customer.getPassword(),"Customer");
	        urService.registerCustomerInRole(userRole);
	        return ResponseEntity.ok(registeredCustomer);
	    }
	 
	
	 
	 @GetMapping("/customers")
	    public ResponseEntity<List<Customer>> getAllCustomers() {
	        List<Customer> customers = cservice.findAllCustomers();
	        return ResponseEntity.ok(customers);
	    }
	 @GetMapping("/{id}")
	    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
	        Optional<Customer> customer = cservice.findCustomerById(id);
	        if (customer.isPresent()) {
	            return ResponseEntity.ok(customer.get());
	        } else {
	            return ResponseEntity.status(404).body("User not found");
	        }
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
		 cservice.deleteCustomer(id);
	        return ResponseEntity.ok().body("User deleted successfully");
	    }
}
