package com.openHopital.userManagement.dao.impl;

import javax.ejb.Stateful;

import com.openHopital.userManagement.dao.AuthoritiesDao;
import com.openHopital.userManagement.entity.Authorities;
@Stateful
public class AuthoritiesDaoImpl extends GenericDaoImpl<Authorities>
		implements AuthoritiesDao {

}
