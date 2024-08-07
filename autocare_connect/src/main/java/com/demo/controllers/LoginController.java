package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Customer;
import com.demo.beans.LoginDetails;
import com.demo.beans.ServiceCenter;
import com.demo.beans.UserRole;
import com.demo.service.CustomerService;
import com.demo.service.ServiceCenterService;
import com.demo.service.UserRoleService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private CustomerService cservice;
    
    @Autowired
    private ServiceCenterService serviceCenterService;
    
    @Autowired
    private UserRoleService urService;
    
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDetails loginDetails) {
        UserRole user = urService.getUSerRole(loginDetails.getEmail(), loginDetails.getPassword());
        
        if (user == null) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
        
        switch (user.getRole().toLowerCase()) {
            case "service center":
                ServiceCenter serviceCenter = serviceCenterService.authenticateServiceCenter(loginDetails.getEmail(), loginDetails.getPassword());
                if (serviceCenter != null) {
                    return ResponseEntity.ok(serviceCenter);
                } else {
                    return ResponseEntity.status(401).body("Invalid email or password");
                }
                
            case "customer":
                Customer customer = cservice.authenticateCustomer(loginDetails.getEmail(), loginDetails.getPassword());
                if (customer != null) {
                    return ResponseEntity.ok(customer);
                } else {
                    return ResponseEntity.status(401).body("Invalid email or password");
                }
                
            case "admin":
                return ResponseEntity.ok("Login Successful: " + user.getEmail());
                
            default:
                return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}

