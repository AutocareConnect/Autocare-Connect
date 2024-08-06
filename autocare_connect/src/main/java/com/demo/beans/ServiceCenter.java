package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServiceCenter {

	

	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int cid;

	    private String name;
	    private String email;
	    private String password;
	    private String phone;
	    private String address;
	    private String pincode;
	    private String working_hours;
	    private String closedDays;
	    
		public ServiceCenter() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ServiceCenter(int cid, String name, String email, String password, String phone, String address,
				String pincode, String working_hours, String closedDays) {
			super();
			this.cid = cid;
			this.name = name;
			this.email = email;
			this.password = password;
			this.phone = phone;
			this.address = address;
			this.pincode = pincode;
			this.working_hours = working_hours;
			this.closedDays = closedDays;
		}

		public int getCid() {
			return cid;
		}

		public void setCid(int cid) {
			this.cid = cid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPincode() {
			return pincode;
		}

		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

		public String getWorking_hours() {
			return working_hours;
		}

		public void setWorking_hours(String working_hours) {
			this.working_hours = working_hours;
		}

		public String getClosedDays() {
			return closedDays;
		}

		public void setClosedDays(String closedDays) {
			this.closedDays = closedDays;
		}

		
	    
	    // Getters and setters
	    // Constructors
	    // Other methods as needed
	}


