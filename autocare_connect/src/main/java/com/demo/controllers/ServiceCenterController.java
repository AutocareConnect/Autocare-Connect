package com.demo.controllers;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.ServiceCenter;
import com.demo.service.ServiceCenterService;

@RestController
@RequestMapping("/service-center")
public class ServiceCenterController {

    @Autowired
    private ServiceCenterService serviceCenterService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ServiceCenter serviceCenter) {
        ServiceCenter registeredServiceCenter = serviceCenterService.registerServiceCenter(serviceCenter);
        return ResponseEntity.ok(registeredServiceCenter);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        ServiceCenter serviceCenter = serviceCenterService.authenticateServiceCenter(email, password);
        if (serviceCenter != null) {
            return ResponseEntity.ok(serviceCenter);
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }

    @GetMapping("/details")
    public ResponseEntity<?> getServiceCenterDetails(@RequestParam String email) {
        ServiceCenter serviceCenter = serviceCenterService.findByEmail(email);
        if (serviceCenter != null) {
            return ResponseEntity.ok(serviceCenter);
        } else {
            return ResponseEntity.status(404).body("Service Center not found");
        }
    }

    @GetMapping
    public ResponseEntity<List<ServiceCenter>> getAllServiceCenters() {
        List<ServiceCenter> serviceCenters = serviceCenterService.findAllServiceCenters();
        return ResponseEntity.ok(serviceCenters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getServiceCenterById(@PathVariable int id) {
        Optional<ServiceCenter> serviceCenter = serviceCenterService.findServiceCenterById(id);
        if (serviceCenter.isPresent()) {
            return ResponseEntity.ok(serviceCenter.get());
        } else {
            return ResponseEntity.status(404).body("Service Center not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateServiceCenter(@PathVariable int id, @RequestBody ServiceCenter updatedServiceCenter) {
        ServiceCenter serviceCenter = serviceCenterService.updateServiceCenter(id, updatedServiceCenter);
        return ResponseEntity.ok(serviceCenter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteServiceCenter(@PathVariable int id) {
        serviceCenterService.deleteServiceCenter(id);
        return ResponseEntity.ok().body("Service Center deleted successfully");
    }
}

