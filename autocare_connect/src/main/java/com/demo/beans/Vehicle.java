package com.demo.beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vid;

    private String name;
    private String number_plate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;

	public Vehicle() {
		super();
	}

	public Vehicle(int vid, String name, String number_plate, Customer customer) {
		super();
		this.vid = vid;
		this.name = name;
		this.number_plate = number_plate;
		this.customer = customer;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber_plate() {
		return number_plate;
	}

	public void setNumber_plate(String number_plate) {
		this.number_plate = number_plate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

    

   
}

