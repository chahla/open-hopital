package com.openHopital.userManagement.controller.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.openHopital.userManagement.controller.UserController;
import com.openHopital.userManagement.dao.UserDAO;
import com.openHopital.userManagement.entity.User;

@Transactional
public class UserControllerImpl implements UserController, UserDetailsService {
	UserDAO userDao;
	
  public UserControllerImpl(UserDAO userdao) {
		this.userDao = userdao;
	}
	
	public User getUser(String username) {
		return userDao.getUser(username);
	}
	
	public User loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		User temp = getUser(username);
		
		if(temp == null){
			throw new UsernameNotFoundException(username + " not found");
		}
		
		return temp;
	}
}
