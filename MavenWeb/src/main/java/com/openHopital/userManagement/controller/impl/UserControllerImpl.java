package com.openHopital.userManagement.controller.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.openHopital.userManagement.controller.UserController;
import com.openHopital.userManagement.entity.User;
import com.openHopital.userManagement.dao.UserDaoImpl;

@Transactional
public class UserControllerImpl implements UserController, UserDetailsService {
	UserDaoImpl userDao;
	
  public UserControllerImpl(UserDaoImpl userdao) {
		this.userDao = userdao;
	}
	
	public User getUser(String userName) {
		return userDao.getUser(userName);
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
