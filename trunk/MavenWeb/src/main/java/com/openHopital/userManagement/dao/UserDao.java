package com.openHopital.userManagement.dao;

import com.openHopital.userManagement.entity.User;

public interface UserDao extends GenericDao<User> {

	public User getUser(String userName);
}
