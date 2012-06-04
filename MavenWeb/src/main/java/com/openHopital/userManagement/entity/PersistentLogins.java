package com.openHopital.userManagement.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "persistent_logins")
public class PersistentLogins implements Serializable {

	private static final long serialVersionUID = 1595224940757689000L;

	@Id
	private String series;
	@Column(nullable = false)
	@ForeignKey(inverseName = "Users", name = "fk_persistent_user")
	private String username;
	@Column(nullable = false)
	private String token;
	@Column(nullable = false)
	private Date lastUsed;

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}
}
