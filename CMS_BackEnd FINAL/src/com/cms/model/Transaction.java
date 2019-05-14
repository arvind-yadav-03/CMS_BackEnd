package com.cms.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cms.entity.CustomerEntity;
import com.cms.entity.TransactionEntity;

public class Transaction {

	private Integer billId;
	private String source;
	private String destination;
	private Date sourceDate;
	private Date destinationDate;
	private String status;
	private Double weight;
	private String packageType;
	
	private Long contactNo;
	private String description;
	private Double amount;
	private Customer  customer;
	
	private Double rating;
	private String message;
	
	private Integer eId;
//	private String customerId;
//	private String customerName;
	
	
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() 
	{
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getSourceDate() {
		return sourceDate;
	}
	public void setSourceDate(Date sourceDate) {
		this.sourceDate = sourceDate;
	}
	public Date getDestinationDate() {
		return destinationDate;
	}
	public void setDestinationDate(Date destinationDate) {
		this.destinationDate = destinationDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
//	public String getCustomerId() {
//		return customerId;
//	}
//	public void setCustomerId(String customerId) {
//		this.customerId = customerId;
//	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
//	public String getCustomerName() {
//		return customerName;
//	}
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}

	public Transaction(){}
	
	public Transaction(TransactionEntity te)
	{
		this.setAmount(te.getAmount());
		this.setBillId(te.getBillId());
		this.setContactNo(te.getContactNo());
		//this.setCustomerId(te.getCustomerId());
		
//		this.setCustomer(te.getCustomer());
		
		// customer 
		
		this.setDescription(te.getDescription());
		this.setDestination(te.getDestination());
		this.setDestinationDate(te.getDestinationDate());
		this.setSource(te.getSource());
		this.setSourceDate(te.getSourceDate());
		this.setPackageType(te.getPackageType());
		this.setWeight(te.getWeight());
		this.setStatus(te.getStatus());
		this.setRating(te.getRating());
		this.setMessage(te.getMessage());
		this.seteId(te.geteId());
		//this.setCustomerName(te.getCustomerName());
		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
