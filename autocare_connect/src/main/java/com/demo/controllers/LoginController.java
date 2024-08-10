package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Customer;
import com.demo.beans.LoginDetails;
import com.demo.beans.ServiceCenter;
import com.demo.beans.UserRole;
import com.demo.security.CustomUserDetailsService;
import com.demo.security.JwtRequest;
import com.demo.security.JwtResponse;
import com.demo.security.JwtUtil;
import com.demo.service.CustomerService;
import com.demo.service.ServiceCenterService;
import com.demo.service.UserRoleService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

	
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private CustomUserDetailsService customUserDetailsService;

	    @Autowired
	    private JwtUtil jwtUtil;
	    
//    @Autowired
//    private CustomerService cservice;
//    
//    @Autowired
//    private ServiceCenterService serviceCenterService;
//    
//    @Autowired
//    private UserRoleService urService;
//    
//    @PostMapping
//    public ResponseEntity<?> login(@RequestBody LoginDetails loginDetails) {
//        UserRole user = urService.getUSerRole(loginDetails.getEmail(), loginDetails.getPassword());
//        
//        if (user == null) {
//            return ResponseEntity.status(401).body("Invalid email or password");
//        }
//        
//        switch (user.getRole().toLowerCase()) {
//            case "service center":
//                ServiceCenter serviceCenter = serviceCenterService.authenticateServiceCenter(loginDetails.getEmail(), loginDetails.getPassword());
//                if (serviceCenter != null) {
//                    return ResponseEntity.ok(serviceCenter);
//                } else {
//                    return ResponseEntity.status(401).body("Invalid email or password");
//                }
//                
//            case "customer":
//                Customer customer = cservice.authenticateCustomer(loginDetails.getEmail(), loginDetails.getPassword());
//                if (customer != null) {
//                    return ResponseEntity.ok(customer);
//                } else {
//                    return ResponseEntity.status(401).body("Invalid email or password");
//                }
//                
//            case "admin":
//                return ResponseEntity.ok("Login Successful: " + user.getEmail());
//                
//            default:
//                return ResponseEntity.status(401).body("Invalid email or password");
//        }
//    }
    
    @PostMapping("/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getEmail());

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new JwtResponse(jwt));
    }
}

