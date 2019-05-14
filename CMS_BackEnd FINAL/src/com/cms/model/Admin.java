package com.cms.model;

import com.cms.entity.AdminEntity;

public class Admin {

	private Integer eId;
	
	private String password;
	
	private String message;
	

	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer empId) {
		this.eId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(){}
	public Admin(AdminEntity ae) 
	{
		this.seteId(ae.geteId());
		this.setPassword(ae.getPassword());
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
