package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.UserRole;
import com.demo.dao.UserRoleDao;


@Service
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	private UserRoleDao urdao;

	@Override
	public void registerScInRole(UserRole userRole) {
		// TODO Auto-generated method stub
		urdao.save(userRole);
	}

	@Override
	public void registerCustomerInRole(UserRole userRole) {
		// TODO Auto-generated method stub
		urdao.save(userRole);
	}

	@Override
	public UserRole getUSerRole(String email, String password) {
		// TODO Auto-generated method stub
		return urdao.findByEmailAndPassword(email,password);
	}

	
}
