package com.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cms.model.Customer;

@Entity
@Table(name="Customer_Details")
@GenericGenerator(name="genId", strategy="increment")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(generator = "genId")
	private Integer custId;
	private String customerName;
	@Column(name="address")
	private String customerAddress;
	private Long contactNumber;
	@Column(name="email")
	private String customerEmail;
	private String feedback;
	private String message;
	
	
	
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}

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
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public CustomerEntity()
	{
			//default constructor
	} 
	
	public CustomerEntity(Customer cust)
	{
		this.setCustId(cust.getCustId());
		this.setContactNumber(cust.getContactNumber());
		this.setCustomerAddress(cust.getCustomerAddress());
		this.setCustomerEmail(cust.getCustomerEmail());
		this.setCustomerName(cust.getCustomerName());
		this.setFeedback(cust.getFeedback());
		this.setMessage(cust.getMessage());
		
	}
	
	

	

}

