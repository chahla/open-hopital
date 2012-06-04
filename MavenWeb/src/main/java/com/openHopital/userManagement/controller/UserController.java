package com.openHopital.userManagement.controller;

import com.openHopital.userManagement.entity.User;

public interface UserController {
	User getUser(String username);

	User loadUserByUsername(String userName);
}
