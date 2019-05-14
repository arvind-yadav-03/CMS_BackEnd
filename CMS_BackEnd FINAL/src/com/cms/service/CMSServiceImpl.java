package com.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;






import com.cms.model.Admin;
import com.cms.model.Contact;
import com.cms.model.Customer;
import com.cms.model.Employee;
import com.cms.model.Transaction;
import com.cms.dao.CmsDAO;

@Service("CMSService")
@Transactional(readOnly = true)
public class CMSServiceImpl implements CMSService {

	@Autowired
	private CmsDAO dao;

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Integer addEmployee(Employee employee) throws Exception {
		Integer empid=dao.addEmployee(employee);
		if(empid==null)
			throw new Exception();
		return empid;
	}

	@Override

	public Employee getEmployeeById(Integer empid) throws Exception {
		return dao.getEmployeeById(empid);
	}

	
	// to be implemented -----------------------------------------------------
	@Override
	public Employee employeeAllocation(Integer empid, Integer contactId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Integer addCustomer(Customer customer) throws Exception {
		Integer custid=dao.addCustomer(customer);
		if(custid==null)
			throw new Exception();
		else
			return custid;
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws Exception 
	{
		return dao.getCustomerById(customerId);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Employee loginEmployee(Employee emp) throws Exception 
	{
		Employee e=dao.loginEmployee(emp);
		if(e==null)
			throw new Exception();
		else
			return e;
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Integer addAdmin(Admin adm) throws Exception {
		Integer empid=dao.addAdmin(adm);
		if(empid==null)
			throw new Exception();
		else
			return empid;
		
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Admin loginAdmin(Admin admin) throws Exception 
	{
		Admin adm=dao.loginAdmin(admin);
		if(adm==null)
			throw new Exception();
		else
			return adm;
	}

	

	@Override
	public Admin getAdminById(Integer empid) throws Exception 
	{
		return dao.getAdminById(empid);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Integer addTransaction(Transaction trans) throws Exception 
	{
		Integer billId=dao.addTransaction(trans);
		if(billId==null)
			throw new Exception();
		else
			return billId;
		
	}
	
	
	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Integer addTransactionExist(Transaction trans) throws Exception 
	{
		Integer billId=dao.addTransactionExist(trans);
		if(billId==null)
			throw new Exception();
		else
			return billId;
		
	}

	@Override
	public Transaction getTransactionById(Integer billId) throws Exception 
	{
		return dao.getTransactionById(billId);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Employee updateEmployeeDetails(Employee employee) throws Exception
	{
		if (dao.getEmployeeById(employee.geteId()) == null)
		{
			throw new Exception("Service.EMPLOYEE_NOT_FOUND");
		}
			return dao.updateEmployeeDetails(employee);
		}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Customer updateCustomerDetails(Customer customer) throws Exception 
	{
		if (dao.getCustomerById(customer.getCustId()) == null) {
			throw new Exception("Service.CUSTOMER_NOT_FOUND");
		}
			return dao.updateCustomerDetails(customer);
		
			
		}
		

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Admin updateAdminDetails(Admin admin) throws Exception 
	{
		if (dao.getAdminById(admin.geteId()) == null) {
			throw new Exception("Service.ADMIN_NOT_FOUND");
		}
		return dao.updateAdminDetails(admin);

		}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Transaction updateTransactionDetails(Transaction trans) throws Exception 
	{
		if (dao.getTransactionById(trans.getBillId()) == null)
		{
			throw new Exception("Service.TRANSACTION_NOT_FOUND");
		}
			return dao.updateTransactionDetails(trans);
		
	}
	
	
	@Override
	public List<Transaction> searchTransactionByAddress(String location) throws Exception 
	{
	List<Transaction> trans = null;
	trans=dao.searchTransactionByAddress(location);
	if(trans==null)
	{
		throw new Exception("Service.NO_TRANSACTION_FOUND");
	}
	
	return trans;
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Integer addContact(Contact contact) throws Exception 
	{
		Integer contactId=dao.addContact(contact);
		if(contactId==null)
			throw new Exception();
		else
			return contactId;
		
		
	}

	@Override
	public Contact getContactById(Integer contactId) throws Exception 
	{
		return dao.getContactById(contactId);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public Contact updateContactDetails(Contact contact) throws Exception
	{
		if (dao.getContactById(contact.getContactId()) == null)
		{
			throw new Exception("Service.CONTACT_NOT_FOUND");
		}
			return dao.updateContactDetails(contact);
	
			
		
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public void deleteEmployeeDetails(Integer empid) throws Exception 
	{
		if (dao.getEmployeeById(empid) != null)
			dao.deleteEmployeeDetails(empid);
		else
			throw new Exception("Service.EMPLOYEE_NOT_FOUND");
		
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public void deleteCustomer(Integer customerId) throws Exception 
	{
		if (dao.getCustomerById(customerId) != null)
			dao.deleteCustomer(customerId);
		else
			throw new Exception("Service.CUSTOMER_NOT_FOUND");
	}
		
	
// admin deletion to be implemented
	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public void deleteAdminDetails(Integer empid) throws Exception 
	{
		if (dao.getAdminById(empid) != null) {
			dao.deleteAdminDetails(empid);
		} 
		else 
		{
			throw new Exception("Service.ADMIN_NOT_FOUND");
		}
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public void deleteTransactionDetails(Integer billId) throws Exception 
	{
		if (dao.getTransactionById(billId) != null)
			dao.deleteTransactionDetails(billId);
		else
			throw new Exception("Service.TRANSACTION_NOT_FOUND");
		
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public void deleteContactDetails(Integer contactId) throws Exception 
	{
		if (dao.getContactById(contactId) != null)
			dao.deleteContactDetails(contactId);
		else
			throw new Exception("Service.CONTACT_NOT_FOUND");
		
		
	}
	

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public void submitFeedback(Customer customer) throws Exception 
	{
		if (dao.getCustomerById(customer.getCustId()) != null) {
			dao.submitFeedback(customer);
		} else {
			throw new Exception("Service.Employee_NOT_FOUND");
		}
		
	}
	
	

	@Override
	public List<Employee> getAllEmployee() throws Exception {
		List<Employee> emp = null;
		emp=dao.getAllEmployee();
		if(emp==null)
		{
			throw new Exception("Service.NO_EMPLOYEE_FOUND");
		}
		return emp;
	}
	
		@Override
		public List<Customer> getAllCustomer() throws Exception 
		{
			List<Customer> customers = null;
			customers=dao.getAllCustomer();
			if(customers==null)
			{
				throw new Exception("Service.NO_CUSTOMES_FOUND");
			}
			return customers;
		}
		
		
		@Override
		public List<Transaction> getAllTransaction() throws Exception 
		{
		List<Transaction> trans = null;
		trans=dao.getAllTransaction();
		if(trans==null)
		{
			throw new Exception("Service.NO_TRANSACTION_FOUND");
		}
		
		return trans;
		}



}
