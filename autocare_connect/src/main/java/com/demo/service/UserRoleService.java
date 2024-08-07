package com.demo.service;

import com.demo.beans.UserRole;

public interface UserRoleService {


	void registerScInRole(UserRole userRole);

	void registerCustomerInRole(UserRole userRole);

	UserRole getUSerRole(String email, String password);

}
