package com.openHopital.userManagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: UserDetail
 * 
 */
@Entity
@Table(name = "User_Detail")
public class UserDetail implements Serializable {

	private static final long serialVersionUID = -3546272261684430021L;
	@Id
	private String username;
	private String userFirstName;
	private String userLastName;
	private String Addressid;

	public UserDetail() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getAddressid() {
		return Addressid;
	}

	public void setAddressid(String addressid) {
		Addressid = addressid;
	}

}
