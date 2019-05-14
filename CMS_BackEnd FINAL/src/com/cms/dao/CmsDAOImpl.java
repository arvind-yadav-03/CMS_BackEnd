package com.cms.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;







import com.cms.entity.AdminEntity;
import com.cms.entity.ContactEntity;
import com.cms.entity.CustomerEntity;
import com.cms.entity.EmployeeEntity;
import com.cms.entity.TransactionEntity;
import com.cms.model.Admin;
import com.cms.model.Contact;
import com.cms.model.Customer;
import com.cms.model.Employee;
import com.cms.model.Transaction;


@Repository("dao")
public class CmsDAOImpl implements CmsDAO {

	@Autowired
	SessionFactory sessionFactory;

	/*-----------------------------------------------Administrator Functions-------------------------------------------------------------------------------------------------*/	
	
	// Administrator functions
	@Override
	public Admin loginAdmin(Admin admin) throws Exception 
	{
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<AdminEntity> criteriaQuery= builder.createQuery(AdminEntity.class);
		Root<AdminEntity> root = criteriaQuery.from(AdminEntity.class);
		criteriaQuery.select(root);
		
		criteriaQuery.where(builder.and(builder.equal(root.get("eId"),admin.geteId())
				,builder.equal(root.get("password"), admin.getPassword())));
		
		AdminEntity adminEntity=session.createQuery(criteriaQuery).uniqueResult();
		if(adminEntity==null)
		{
			throw new Exception("Service.LOGIN_FAILURE_PASS_MM");
		}
		Admin adm=new Admin(adminEntity);
		return adm;	
	}
	
	@Override
	public Integer addAdmin(Admin admin) throws Exception {
		Session session =sessionFactory.getCurrentSession();
		AdminEntity ae=new AdminEntity(admin);
		return (Integer) session.save(ae);
	}
	
	@Override
	public Admin updateAdminDetails(Admin admin) throws Exception 
	{
		Session session = sessionFactory.getCurrentSession();
        AdminEntity adminEntity = session.get(AdminEntity.class,admin.geteId());
    
        adminEntity.setPassword(admin.getPassword());
        return admin;
	}
	
	@Override
	public void deleteAdminDetails(Integer empid) throws Exception
	{
		Session session = sessionFactory.getCurrentSession();
        AdminEntity adminEntity = session.get(AdminEntity.class,empid);
		session.delete(adminEntity);
	}
	
	
	// fetch admin details by id

	@Override
	public Admin getAdminById(Integer eId) throws Exception 
	{
		Session session =sessionFactory.getCurrentSession();
		AdminEntity adminEntity=session.get(AdminEntity.class,eId);
		if(adminEntity==null)
		{
			throw new Exception();
		}
		Admin admin=new Admin(adminEntity);
		return admin;
	}
/*-----------------------------------------------Employee Functions-------------------------------------------------------------------------------------------------*/	
	
	
	// Employee Functions
	@Override
	public Employee loginEmployee(Employee emp) throws Exception 
	{
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<EmployeeEntity> criteriaQuery= builder.createQuery(EmployeeEntity.class);
		Root<EmployeeEntity> root = criteriaQuery.from(EmployeeEntity.class);
		criteriaQuery.select(root);
		
		//root.get(value)   value should be attribute not the column name
		criteriaQuery.where(builder.and(builder.equal(root.get("eId"), emp.geteId()),
				builder.equal(root.get("password"), emp.getPassword())));
		EmployeeEntity ee=session.createQuery(criteriaQuery).uniqueResult();
//		System.out.println("value of ee-------"+ee);
		if(ee==null)
		{
			throw new Exception("Service.LOGIN_FAILURE_PASS_MM");
		}
		Employee e=new Employee(ee);
		return e;	
	}
	
	
	@Override
	public Integer addEmployee(Employee employee) throws Exception 
	{
		Session session =sessionFactory.getCurrentSession();
		EmployeeEntity ee=new EmployeeEntity(employee);
		return (Integer) session.save(ee);
		
	}

	@Override
	public Employee getEmployeeById(Integer empId) throws Exception 
	{
		Session session =sessionFactory.getCurrentSession();
		EmployeeEntity ee=session.get(EmployeeEntity.class,empId);
		if(ee==null)
		{
			throw new Exception();
		}
		Employee emp=new Employee(ee);
		return emp;
	}

	@Override
	public Employee updateEmployeeDetails(Employee employee) throws Exception 
	{
		Session session = sessionFactory.getCurrentSession();
        EmployeeEntity employeeEntity = session.get(EmployeeEntity.class,employee.geteId());
        
		employeeEntity.setName(employee.getName());
		employeeEntity.setEmail(employee.getEmail());
		employeeEntity.setContactNumber(employee.getContactNumber());
		employeeEntity.setDesignation(employee.getDesignation());
		//employeeEntity.setRating(employee.getRating());
		employeeEntity.setPassword(employee.getPassword());
		employeeEntity.setAddress(employee.getAddress());
		employeeEntity.setDateOfJoining(employee.getDateOfJoining());
		return employee;
	}
	

	@Override
    public List<Employee> getAllEmployee() throws Exception 
	{
        Session session = sessionFactory.getCurrentSession();
		
        List<Employee> emp = new ArrayList<>();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> criteriaQuery= builder.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> root = criteriaQuery.from(EmployeeEntity.class);
        criteriaQuery.select(root);
        List<EmployeeEntity> EmployeeEntityList = session.createQuery(criteriaQuery).list();

        for (EmployeeEntity employeeEntity : EmployeeEntityList) 
		{
            Employee employee = new Employee(employeeEntity);
			
			
            emp.add(employee);
        }
        return emp;
    }
	
	@Override
	public void deleteEmployeeDetails(Integer empid) throws Exception 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeEntity employeeEntity = session.get(EmployeeEntity.class,empid);
        session.delete(employeeEntity);
		
	}
	
	/*-----------------------------------------------Customer Functions-------------------------------------------------------------------------------------------------*/	
	
	// Customer Functions
	@Override
	public Integer addCustomer(Customer customer) throws Exception {
		Session session =sessionFactory.getCurrentSession();
		CustomerEntity ce=new CustomerEntity(customer);
		return (Integer) session.save(ce);
	
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws Exception {
		Session session =sessionFactory.getCurrentSession();
		CustomerEntity ce=session.get(CustomerEntity.class,customerId);
		if(ce==null)
		{
			throw new Exception();
		}
		Customer cust=new Customer(ce);
		return cust;
	}
	
	
	@Override
	public Customer updateCustomerDetails(Customer customer) throws Exception 
	{
		Session session = sessionFactory.getCurrentSession();
        CustomerEntity customerEntity = session.get(CustomerEntity.class,customer.getCustId());
        
		customerEntity.setContactNumber(customer.getContactNumber());
		customerEntity.setCustomerAddress(customer.getCustomerAddress());
		customerEntity.setCustomerEmail(customer.getCustomerEmail());
		customerEntity.setCustomerName(customer.getCustomerName());
		customerEntity.setFeedback(customer.getFeedback());		
		return customer;
	}

	@Override
	public void deleteCustomer(Integer customerId) throws Exception 
	{
		Session session = sessionFactory.getCurrentSession();
        CustomerEntity customerEntity = session.get(CustomerEntity.class, customerId);
        session.delete(customerEntity);

	}

	List<Integer> customerAll = new ArrayList<>();
	
	@Override
	public List<Customer> getAllCustomer() throws Exception 
	{
        Session session = sessionFactory.getCurrentSession();
		
        List<Customer> cust = new ArrayList<>();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CustomerEntity> criteriaQuery= builder.createQuery(CustomerEntity.class);
        Root<CustomerEntity> root = criteriaQuery.from(CustomerEntity.class);
        criteriaQuery.select(root);
        List<CustomerEntity> customerEntityList = session.createQuery(criteriaQuery).list();

        for (CustomerEntity customerEntity : customerEntityList) 
		{
            Customer customer = new Customer(customerEntity);
            
            customerAll.add(customer.getCustId());
			//customer();
			
            cust.add(customer);
        }
        return cust;
	}
	

	@Override
	public void submitFeedback(Customer customer) throws Exception 
	{
		Session session = sessionFactory.getCurrentSession();
      		CustomerEntity customerEntity = session.get(CustomerEntity.class,customer.getCustId());
		customerEntity.setFeedback(customer.getFeedback());		
		
	}
	
	

	
	
/*-----------------------------------------------Transaction Functions-------------------------------------------------------------------------------------------------*/	
// Transaction Functions
	@Override
	public Integer addTransaction(Transaction trans) throws Exception
	{
		Session session =sessionFactory.getCurrentSession();
		TransactionEntity te=new TransactionEntity(trans);

		
		
		if (trans.getCustomer() != null)
		{
			CustomerEntity ce=new CustomerEntity();
			Customer customer=trans.getCustomer();

			ce.setCustId(customer.getCustId());
			ce.setContactNumber(customer.getContactNumber());
			ce.setCustomerAddress(customer.getCustomerAddress());
			ce.setCustomerEmail(customer.getCustomerEmail());
			ce.setCustomerName(customer.getCustomerName());
			ce.setFeedback(customer.getFeedback());
			ce.setMessage(customer.getMessage());
			session.save(ce);
			te.setCustomer(ce);

		}
		Integer result=(Integer) session.save(te);
		Integer empId=trans.geteId();
		
//		System.out.println("result "+result);
		
		
		       Double rating = null;
		     //select avg(rating) from Booking_details where eId=    5628231)
		       session = sessionFactory.getCurrentSession();
		       CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		       CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);
		       Root<TransactionEntity> root = criteriaQuery.from(TransactionEntity.class);
		       criteriaQuery.select(criteriaBuilder.avg(root.get("rating")));
		       criteriaQuery.where(criteriaBuilder.equal(root.get("eId"),empId));
		       
		       rating = session.createQuery(criteriaQuery).getSingleResult();
		       System.out.println(rating);
		       
		       
		       //--update  Employee_Details set rating=avg where eId=562823;

		       EmployeeEntity ee = session.get(EmployeeEntity.class,empId);
				if (ee != null) {
					ee.setRating(rating);
					
				}

		return result;
	}
	
	
	

	@Override
	public Integer addTransactionExist(Transaction trans) throws Exception
	{
		Session session =sessionFactory.getCurrentSession();
		TransactionEntity te=new TransactionEntity(trans);

		
		
		if (trans.getCustomer() != null)
		{
			CustomerEntity ce=new CustomerEntity();
			Customer customer=trans.getCustomer();

			ce.setCustId(customer.getCustId());
			ce.setContactNumber(customer.getContactNumber());
			ce.setCustomerAddress(customer.getCustomerAddress());
			ce.setCustomerEmail(customer.getCustomerEmail());
			ce.setCustomerName(customer.getCustomerName());
			ce.setFeedback(customer.getFeedback());
			ce.setMessage(customer.getMessage());
			
			
			te.setCustomer(ce);

		}
		
		
		
		Integer result=(Integer) session.save(te);
		Integer empId=trans.geteId();
		
//		System.out.println("result "+result);
		
		
		       Double rating = null;
		     //select avg(rating) from Booking_details where eId=    5628231)
		       session = sessionFactory.getCurrentSession();
		       CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		       CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);
		       Root<TransactionEntity> root = criteriaQuery.from(TransactionEntity.class);
		       criteriaQuery.select(criteriaBuilder.avg(root.get("rating")));
		       criteriaQuery.where(criteriaBuilder.equal(root.get("eId"),empId));
		       
		       rating = session.createQuery(criteriaQuery).getSingleResult();
		       System.out.println(rating);
		       
		       
		       //--update  Employee_Details set rating=avg where eId=562823;

		       EmployeeEntity ee = session.get(EmployeeEntity.class,empId);
				if (ee != null) {
					ee.setRating(rating);
					
				}
		       
		       
		       
		return result;
	}
	
	
	
	@Override
	public Transaction getTransactionById(Integer billId) throws Exception
	{
		Session session =sessionFactory.getCurrentSession();
		
		TransactionEntity te=session.get(TransactionEntity.class,billId);
		System.out.println(te);
		if(te==null)
		{
			throw new Exception();
		}
		Transaction tr=new Transaction(te);
		System.out.println(tr);
		return tr;
	}
	@Override
    public List<Transaction> searchTransactionByAddress(String location) throws Exception 
	{
        Session session = sessionFactory.getCurrentSession();
		
        String searchLocation =location;// "";//value to be passed from FrontEnd 
        
		List<Transaction> transactions = new ArrayList<>();
        
		CriteriaBuilder builder = session.getCriteriaBuilder();
        
		CriteriaQuery<TransactionEntity> criteriaQuery= builder.createQuery(TransactionEntity.class);
        
		Root<TransactionEntity> root = criteriaQuery.from(TransactionEntity.class);
		
        criteriaQuery.select(root);
		
        criteriaQuery.where(builder.or(builder.like(root.get("source"), searchLocation + "%"),builder.like(root.get("destination"), searchLocation + "%")));
        List<TransactionEntity> transactionEntityList = session.createQuery(criteriaQuery).getResultList();

        for (TransactionEntity transactionEntity : transactionEntityList) {
            Transaction transaction = new Transaction(transactionEntity);

            transactions.add(transaction);
        }
        return transactions;
	}
	
	
	
	@Override
	public Transaction updateTransactionDetails(Transaction transaction) throws Exception 
	{
		Session session = sessionFactory.getCurrentSession();
        TransactionEntity transactionEntity = session.get(TransactionEntity.class,transaction.getBillId());
        
        transactionEntity.setAmount(transaction.getAmount());
		//transactionEntity.setBillId(transaction.getBillId());
		transactionEntity.setContactNo(transaction.getContactNo());
		//transactionEntity.setCustomerId(transaction.getCustomerId());
		transactionEntity.setDescription(transaction.getDescription());
		//transactionEntity.setDestination(transaction.getDestination());
		transactionEntity.setDestinationDate(transaction.getDestinationDate());
		//transactionEntity.setSource(transaction.getSource());
		//transactionEntity.setSourceDate(transaction.getSourceDate());
		transactionEntity.setPackageType(transaction.getPackageType());
		transactionEntity.setWeight(transaction.getWeight());
		transactionEntity.setStatus(transaction.getStatus());
		//transactionEntity.setRating(transaction.getRating());

		return transaction;
		
	}
	

	@Override
	public void deleteTransactionDetails(Integer billId) throws Exception 
	{
		Session session = sessionFactory.getCurrentSession();
        TransactionEntity transactionEntity = session.get(TransactionEntity.class,billId);
        session.delete(transactionEntity);
		
	}
	
	@Override
	public List<Transaction> getAllTransaction() throws Exception 
	{
        Session session = sessionFactory.getCurrentSession();
		
        List<Transaction> trans = new ArrayList<>();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TransactionEntity> criteriaQuery= builder.createQuery(TransactionEntity.class);
        Root<TransactionEntity> root = criteriaQuery.from(TransactionEntity.class);
        criteriaQuery.select(root);
        List<TransactionEntity> transactionEntityList = session.createQuery(criteriaQuery).list();

        for (TransactionEntity transactionEntity : transactionEntityList) 
		{
            Transaction transaction = new Transaction(transactionEntity);
			//transaction(transactionEntity);
			
            trans.add(transaction);
        }
        System.out.println(customerAll);
        return trans;
    }
	

/*-----------------------------------------------Contact Functions-------------------------------------------------------------------------------------------------*/	
	
//Contact Details
	
	
	@Override
	public Employee employeeAllocation(Integer empid, Integer contactId)throws Exception 
	{
		Session session =sessionFactory.getCurrentSession();
		EmployeeEntity ee=session.get(EmployeeEntity.class,empid);
		ContactEntity ce=session.get(ContactEntity.class, contactId);
		if(ee==null)
		{
			throw new Exception();
		}
		if(ce==null)
		{
			throw new Exception();
		}
		
		return null;
	}

	
	
	
	@Override
	public Integer addContact(Contact contact) throws Exception 
	{
		Session session =sessionFactory.getCurrentSession();
		ContactEntity contactEntity=new ContactEntity(contact);
		return (Integer) session.save(contactEntity);
	}
	
	@Override
	public Contact getContactById(Integer contactId) throws Exception 
	{
		Session session =sessionFactory.getCurrentSession();
		ContactEntity contactEntity=session.get(ContactEntity.class,contactId);
		if(contactEntity==null)
		{
			throw new Exception();
		}
		Contact contact=new Contact(contactEntity);
		return contact;
	}
	
	@Override
	public Contact updateContactDetails(Contact contact) throws Exception 
	{
		Session session = sessionFactory.getCurrentSession();
		ContactEntity contactEntity = session.get(ContactEntity.class,contact.getContactId());
		
		//contactEntity.setCustomerName(contact.getCustomerName());
		contactEntity.setContactNumber(contact.getContactNumber());
		//contactEntity.setDate(contact.getDate());
		contactEntity.setDescription(contact.getDescription());
		contactEntity.setEmail(contact.getEmail());
		contactEntity.setEmployeeName(contact.getEmployeeName());
		contactEntity.setLocation(contact.getLocation());
		return contact;
	}

	@Override
	public void deleteContactDetails(Integer contactId) throws Exception 
	{
		Session session = sessionFactory.getCurrentSession();
        ContactEntity contactEntity = session.get(ContactEntity.class,contactId);
        session.delete(contactEntity);
		
	}
	







	



}
