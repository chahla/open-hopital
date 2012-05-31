package com.openHospital.userManagement.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.openHopital.userManagement.dao.GenericDaoJpaImpl;
import com.openHopital.userManagement.entity.Authorities;
import com.openHopital.userManagement.entity.Groups;
import com.openHopital.userManagement.entity.User;

public class DaoTest {

	public static void main(String[] args) {
		
		Authorities authorities = new Authorities();
		authorities.setAuthority("authority");
		GenericDaoJpaImpl<User, Serializable> autherityDao = new GenericDaoJpaImpl<User, Serializable>();
		
		Groups group = new Groups();
		group.setId(1);
		group.setAuthorityId(1);
		group.setGroupName("groupName");
		GenericDaoJpaImpl<User, Serializable> groupDao = new GenericDaoJpaImpl<User, Serializable>();
		
		List<Authorities> authuritiesList = new ArrayList<Authorities>();
		authuritiesList.add(authorities);
		
		User user = new User();
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setGroupId(group.getId());
		user.setPassword("password");
		user.setSystemAuthorities(authuritiesList);
		user.setUsername("username");
		GenericDaoJpaImpl<User, Serializable> userDao = new GenericDaoJpaImpl<User, Serializable>();
		userDao.create(user);
	}
	
	
	
}
