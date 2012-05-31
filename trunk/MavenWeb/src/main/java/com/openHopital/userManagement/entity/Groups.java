package com.openHopital.userManagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ForeignKey;

/**
 * Entity implementation class for Entity: Groups
 * 
 */
@Entity
public class Groups implements Serializable {

	private static final long serialVersionUID = 3992890378060588591L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;	
	private String groupName;
	@ForeignKey(inverseName="Authorities",name="fk_group_authorities_group")
	private int authorityId;

	public Groups() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

}
