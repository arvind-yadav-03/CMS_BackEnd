package com.cms.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cms.model.Customer;
import com.cms.model.Transaction;



@Entity
@Table(name="Booking_Details")
@GenericGenerator(name="genId", strategy="increment")
public class TransactionEntity {

	@Id
	@GeneratedValue(generator = "genId")
	private Integer billId;
	private String source;
	private String destination;
	private Date sourceDate;
	private Date destinationDate;
	private String status;
	private Double weight;
	private Double amount;
	@Column(name="type_package")
	private String packageType;
	//private String customerId;
	private Double rating;
	@Column(name="courierDescription")
	private String description;
	private Long contactNo;
	private String message;
	private Integer eId;
	//private String customerName;
	
	
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="customerId",updatable = false)
	private CustomerEntity  customer;
	
	
	public CustomerEntity getCustomer() 
	{
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
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
	public String getDestination() {
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
//	public String getCustomerId() {
//		return customerId;
//	}
//	public void setCustomerId(String customerId) {
//		this.customerId = customerId;
//	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
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
	
	public TransactionEntity(){}
	
	public TransactionEntity(Transaction t)
	{
		this.setAmount(t.getAmount());
		this.setBillId(t.getBillId());
		this.setContactNo(t.getContactNo());
//		this.setCustomerId(t.getCustomerId());
		this.setDescription(t.getDescription());
		this.setDestination(t.getDestination());
		
		Customer customer = t.getCustomer();
		CustomerEntity ce = new CustomerEntity(customer);
		this.setCustomer(ce);
		
		
//		this.setCustomer(t.getCustomer());
		this.setRating(t.getRating());
		this.setDestinationDate(t.getDestinationDate());
		this.setSource(t.getSource());
		this.setSourceDate(t.getSourceDate());
		this.setPackageType(t.getPackageType());
		this.setWeight(t.getWeight());
		this.setStatus(t.getStatus());
		this.setMessage(t.getMessage());
		this.seteId(t.geteId());
		
//		this.setCustomerName(t.getCustomerName());
	}
	

}
