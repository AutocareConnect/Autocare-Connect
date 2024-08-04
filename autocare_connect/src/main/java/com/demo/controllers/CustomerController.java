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
import com.demo.service.CustomerService;



@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerService cservice;
	
	 @PostMapping("/register")
	    public ResponseEntity<?> register(@RequestBody Customer customer) {
	        Customer registeredCustomer = cservice.registerCustomer(customer);
	        return ResponseEntity.ok(registeredCustomer);
	    }
	 
	 @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
		 Customer customer = cservice.authenticateUser(email, password);
	        if (customer != null) {
	            return ResponseEntity.ok(customer);
	        } else {
	            return ResponseEntity.status(401).body("Invalid email or password");
	        }
	    }
	 
	 @GetMapping("/customers")
	    public ResponseEntity<List<Customer>> getAllUsers() {
	        List<Customer> customers = cservice.findAllCustomers();
	        return ResponseEntity.ok(customers);
	    }
	 @GetMapping("/{id}")
	    public ResponseEntity<?> getUserById(@PathVariable int id) {
	        Optional<Customer> customer = cservice.findUserById(id);
	        if (customer.isPresent()) {
	            return ResponseEntity.ok(customer.get());
	        } else {
	            return ResponseEntity.status(404).body("User not found");
	        }
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteUser(@PathVariable int id) {
		 cservice.deleteUser(id);
	        return ResponseEntity.ok().body("User deleted successfully");
	    }
}
