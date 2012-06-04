package com.openHopital.userManagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.ForeignKey;

/**
 * Entity implementation class for Entity: Authorities
 * 
 */
@Entity
@ForeignKey(name = "fk_authorities_users", inverseName = "USERS")
public class Authorities implements Serializable {

	private static final long serialVersionUID = -2883901917977075955L;
	@Id
	@Column(nullable = false)
	private String authority;

	public Authorities() {
		super();
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
