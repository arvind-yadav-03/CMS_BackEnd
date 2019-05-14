package com.cms.model;

import com.cms.entity.CustomerEntity;



public class Customer {
	
	private Integer custId;
	private String customerName;
	private String customerAddress;
	private Long contactNumber;
	private String customerEmail;
	private String feedback;
	private String message;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	public Customer()
	{
			//default constructor
	} 
	
	public Customer(CustomerEntity ce)
	{
		this.setCustId(ce.getCustId());
		this.setContactNumber(ce.getContactNumber());
		this.setCustomerAddress(ce.getCustomerAddress());
		this.setCustomerEmail(ce.getCustomerEmail());
		this.setCustomerName(ce.getCustomerName());
		this.setFeedback(ce.getFeedback());
		this.setMessage(ce.getMessage());
		
	}
	
	

	
	

}
