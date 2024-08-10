package com.demo.security;

import com.demo.beans.UserRole;
import com.demo.dao.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("in loadbyusername "+username);
        UserRole userRole = userRoleDao.findByEmail(username);
        System.out.println("from database"+userRole);
        if (userRole == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new org.springframework.security.core.userdetails.User(userRole.getEmail(), userRole.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + userRole.getRole().toUpperCase())));
    }
//    	System.out.println("in loadbyusername "+username);
//		CustomUserDetails userDetails=null;
//		UserRole userRole=userRoleDao.findByEmail(username);
//		System.out.println("from database"+userRole);
//		if(userRole!=null) {
//			userDetails=new CustomUserDetails();
//			userDetails.setUser(userRole);
//			
//		}else {
//			throw new UsernameNotFoundException("User not exists");
//		}
//		return userDetails;
//	}
}
