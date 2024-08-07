package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Services {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private double cost;
	
	 @ManyToOne
	 @JsonIgnore
	    private ServiceCenter serviceCenter;

	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Services(int id, String description, double cost, ServiceCenter serviceCenter) {
		super();
		this.id = id;
		this.description = description;
		this.cost = cost;
		this.serviceCenter = serviceCenter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public ServiceCenter getServiceCenter() {
		return serviceCenter;
	}

	public void setServiceCenter(ServiceCenter serviceCenter) {
		this.serviceCenter = serviceCenter;
	}

	
	 
	 
}
