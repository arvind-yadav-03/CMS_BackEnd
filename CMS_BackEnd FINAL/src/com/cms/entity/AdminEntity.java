package com.cms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cms.model.Admin;


@Entity
@Table(name="Admin_Details")
public class AdminEntity {
	@Id
	private Integer eId;
	private String password;
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public AdminEntity(){}
	public AdminEntity(Admin adm)
	{
		this.seteId(adm.geteId());
		this.setPassword(adm.getPassword());
	}
}



