package com.cms.model;

import com.cms.entity.EmployeeEntity;

import java.util.Date;

public class Employee {
	
	private Integer eId;
	private String name;
	private String password;
	private String email;
	private Long contactNumber;
	private String designation;
	private Double rating;
	private Date dateOfJoining;
	private String address;
	private String message;
//	private Integer numberofOrders;
//	
//	public Integer getNumberofOrders() {
//		return numberofOrders;
//	}
//	public void setNumberofOrders(Integer numberofOrders) {
//		this.numberofOrders = numberofOrders;
//	}
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Employee()
	{
		// TODO Auto-generated constructor stub
	}
	public Employee(EmployeeEntity ee)
	{
		this.seteId(ee.geteId());
		this.setName(ee.getName());
		this.setContactNumber(ee.getContactNumber());
		this.setDesignation(ee.getDesignation());
		this.setEmail(ee.getEmail());
		this.setRating(ee.getRating());
//		this.setNumberofOrders(ee.getNumberofOrders());
		this.setPassword(ee.getPassword());
		this.setAddress(ee.getAddress());
		this.setDateOfJoining(ee.getDateOfJoining());
		this.setMessage(ee.getMessage());
		
		
		
	}
	
	
	
}
