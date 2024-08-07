package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.beans.Services;
import com.demo.service.ServicesService;

@RestController
@RequestMapping("/services") // Base path for the controller
public class ServicesController {

    @Autowired
    private ServicesService service;

    @GetMapping
    public ResponseEntity<List<Services>> getAllServices() {
        List<Services> services = service.getAllServices();
        return ResponseEntity.ok(services);
    }

    @GetMapping("/serviceCenter/{serviceCenterId}")
    public ResponseEntity<List<Services>> getServicesByServiceCenter(@PathVariable int serviceCenterId) {
        List<Services> services = service.getServicesByServiceCenter(serviceCenterId);
        return ResponseEntity.ok(services);
    }

    @PostMapping
    public ResponseEntity<Services> addService(@RequestBody Services services) {
        Services createdService = service.addService(services);
        return ResponseEntity.ok(createdService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable int id) {
        service.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
