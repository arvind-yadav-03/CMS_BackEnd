package com.cms.entity;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cms.model.Contact;

@Entity
@Table(name = "Contact_Details")
@GenericGenerator(name="id", strategy="increment")
public class ContactEntity 
{
	@Id
	@GeneratedValue(generator="id")
	private Integer contactId;
	private String customerName;
	@Column(name="employeeAssigned")
	private String employeeName;
	private Long contactNumber;
	private String email;
	private String description;
	private String location;
	@Column(name="doj")
	private Calendar date;
	private String message;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ContactEntity() {
	}
	
	public ContactEntity(Contact c)
	{
		this.setContactId(c.getContactId());
		this.setCustomerName(c.getCustomerName());
		this.setContactNumber(c.getContactNumber());
		this.setDate(c.getDate());
		this.setDescription(c.getDescription());
		this.setEmail(c.getEmail());
		this.setEmployeeName(c.getEmployeeName());
		this.setLocation(c.getLocation());
		this.setMessage(c.getMessage());
	}
	

}



