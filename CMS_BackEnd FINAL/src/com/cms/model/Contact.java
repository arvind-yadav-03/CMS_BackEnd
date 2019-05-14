package com.cms.model;

import java.util.Calendar;

import com.cms.entity.ContactEntity;

public class Contact {

	private Integer contactId;
	private String customerName;
	private String employeeName;
	private Long contactNumber;
	private String email;
	private String description;
	private String location;
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
	public void setDate(Calendar date) 
	{
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
	
	public Contact()
	{
		//default constructor
	}
	
	public Contact(ContactEntity ce)
	{
		this.setContactId(ce.getContactId());
		this.setCustomerName(ce.getCustomerName());
		this.setContactNumber(ce.getContactNumber());
		this.setDate(ce.getDate());
		this.setDescription(ce.getDescription());
		this.setEmail(ce.getEmail());
		this.setEmployeeName(ce.getEmployeeName());
		this.setLocation(ce.getLocation());
		this.setMessage(ce.getMessage());
	}
	
	
}
