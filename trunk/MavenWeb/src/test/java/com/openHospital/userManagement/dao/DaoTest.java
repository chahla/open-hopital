package com.openHospital.userManagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.openHopital.userManagement.dao.AuthoritiesDao;
import com.openHopital.userManagement.dao.GroupsDao;
import com.openHopital.userManagement.dao.UserDao;
import com.openHopital.userManagement.dao.impl.AuthoritiesDaoImpl;
import com.openHopital.userManagement.dao.impl.GroupsDaoImpl;
import com.openHopital.userManagement.dao.impl.UserDaoImpl;
import com.openHopital.userManagement.entity.Authorities;
import com.openHopital.userManagement.entity.Groups;
import com.openHopital.userManagement.entity.User;

public class DaoTest {

	public static void main(String[] args) {

		EntityManager em = getEntityManager("userManagement");

		Authorities authorities = new Authorities();
		authorities.setAuthority("authority1");
		AuthoritiesDao autherityDao = new AuthoritiesDaoImpl();
		autherityDao.setEntityManager(em);

		Groups group = new Groups();
		group.setId(1);
		group.setAuthorityId(1);
		group.setGroupName("groupName1");
		GroupsDao groupDao = new GroupsDaoImpl();
		groupDao.setEntityManager(em);

		List<Authorities> authuritiesList = new ArrayList<Authorities>();
		authuritiesList.add(authorities);

		User user = new User();
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setGroupId(group.getId());
		user.setPassword("password1");
		user.setSystemAuthorities(authuritiesList);
		user.setUsername("username1");
		UserDao userDao = new UserDaoImpl();
		userDao.setEntityManager(em);

		em.getTransaction().begin();
		autherityDao.create(authorities);
		groupDao.create(group);
		userDao.create(user);
		em.getTransaction().commit();
	}

	private static EntityManager getEntityManager(String persistenceName) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(persistenceName);
		EntityManager em = emf.createEntityManager();
		return em;
	}

}
