package com.cms.dao;

import java.util.List;

import com.cms.model.Admin;
import com.cms.model.Contact;
import com.cms.model.Customer;
import com.cms.model.Employee;
import com.cms.model.Transaction;




public interface CmsDAO {
	
	public Integer addEmployee(Employee employee) throws Exception;
	public Employee getEmployeeById(Integer empid) throws Exception;
	public Employee updateEmployeeDetails(Employee employee) throws Exception ;
	public void deleteEmployeeDetails(Integer empid) throws Exception ;
	
	public Employee loginEmployee(Employee emp) throws Exception;
	
	public Employee employeeAllocation(Integer empid, Integer contactId) throws Exception;
	
	
	
	
	public Integer addCustomer(Customer customer) throws Exception;
	public Customer getCustomerById(Integer customerId)throws Exception;
	public Customer updateCustomerDetails(Customer customer) throws Exception;
    public void deleteCustomer(Integer customerId) throws Exception;
	
	
	public Integer addAdmin(Admin employee) throws Exception;
	public Admin loginAdmin(Admin admin) throws Exception;
	public Admin updateAdminDetails(Admin admin)throws Exception;
	public void deleteAdminDetails(Integer empId)throws Exception;
	public Admin getAdminById(Integer empid) throws Exception;
	
	public Integer addTransaction(Transaction trans) throws Exception;
	public Integer addTransactionExist(Transaction trans) throws Exception;
	public Transaction getTransactionById(Integer billId) throws Exception;
	public Transaction updateTransactionDetails(Transaction trans) throws Exception;
	public void deleteTransactionDetails(Integer billId) throws Exception;
	
	
	
	public Integer addContact(Contact contact) throws Exception;
	public Contact getContactById(Integer contactId) throws Exception;
	public Contact updateContactDetails(Contact contact) throws Exception;
	public void deleteContactDetails(Integer contactId) throws Exception;
	public List<Transaction> getAllTransaction() throws Exception;
	public List<Customer> getAllCustomer() throws Exception;
	public List<Employee> getAllEmployee() throws Exception;
	public void submitFeedback(Customer customer) throws Exception;
	public List<Transaction> searchTransactionByAddress(String location) throws Exception ;
	
	
}
