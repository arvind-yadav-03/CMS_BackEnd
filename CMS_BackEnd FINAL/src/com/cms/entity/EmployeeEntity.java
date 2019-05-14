package com.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import com.cms.model.Employee;

import java.util.Date;

@Entity
@Table(name="Employee_Details")
@GenericGenerator(name="id", strategy="increment")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(generator="id")
	//@Column(name = "empId")
	private Integer eId;
	@Column(name = "employeeName")
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
//		this.numberofOrders=numberofOrders;
//	}
	public Integer geteId() 
	{
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
	
	public EmployeeEntity()
	{
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeEntity(Employee emp)
	{
		this.seteId(emp.geteId());
		this.setName(emp.getName());
		this.setEmail(emp.getEmail());
//		this.setNumberofOrders(emp.getNumberofOrders());
		this.setContactNumber(emp.getContactNumber());
		this.setDesignation(emp.getDesignation());
		this.setRating(emp.getRating());
		this.setPassword(emp.getPassword());
		this.setAddress(emp.getAddress());
		this.setDateOfJoining(emp.getDateOfJoining());
		this.setMessage(emp.getMessage());

	}
	
}

