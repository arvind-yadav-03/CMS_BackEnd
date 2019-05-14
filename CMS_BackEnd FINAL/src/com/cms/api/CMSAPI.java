package com.cms.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;









import com.cms.model.Admin;
import com.cms.model.Contact;
import com.cms.model.Customer;
//import com.cms.entity.EmployeeEntity;
import com.cms.model.Employee;
import com.cms.model.Transaction;
//import com.cms.model.Transaction;
import com.cms.service.CMSService;
import com.cms.service.CMSServiceImpl;
import com.cms.utility.ContextFactory;

@RestController
@CrossOrigin
@RequestMapping("CMSAPI")
public class CMSAPI 
{
	static CMSService service=ContextFactory.getContext().getBean(CMSServiceImpl.class);
	static Environment en=ContextFactory.getContext().getEnvironment();
	
	
	//--------------------------EMPLOYEE--------------------------
	
	@PostMapping("addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		ResponseEntity<Employee> responseEntity=null;

		Integer empId=null;
		Employee em=new Employee();
		
		try
		{
			empId=service.addEmployee(employee);
			em.seteId(empId);
			String msg = en.getProperty("Service.EMPLOYEE_ADDED");
			
			em.setMessage(msg);
			responseEntity =new ResponseEntity<Employee>(em,HttpStatus.OK);
			
		}
		catch(Exception e)
		{
			String error = en.getProperty("Service.EMPLOYEE_ALREADY_EXISTS");
			Employee emp = new Employee();
			emp.setMessage(error);
			responseEntity = new ResponseEntity<Employee>(emp,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
		
	}
	
	
	@PostMapping("loginEmployee")
	public ResponseEntity<Employee> loginEmployee(@RequestBody Employee employee)
	{
		ResponseEntity<Employee> responseEntity=null;

		Employee emp =new Employee();
		
		try
		{
			emp=service.loginEmployee(employee);
			emp.setMessage(en.getProperty("Service.LOGIN_SUCCESS"));
			responseEntity =new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = en.getProperty("Service.LOGIN_FAILURE_PASS_MM");
			Employee emp1 = new Employee();
			emp1.setMessage(error);
			responseEntity = new ResponseEntity<Employee>(emp1,HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
		
	}
	
	
	@GetMapping("getEmployeeById/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empid") Integer empid)
	{
		ResponseEntity<Employee> res=null;
		Employee emp=new Employee();
		try{
			emp=service.getEmployeeById(empid);
			emp.setMessage("Success");
			res=new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}
		catch(Exception e)
		{
			Employee emp1=new Employee();
			emp1.setMessage(en.getProperty("Service.EMPLOYEE_NOT_FOUND"));
			res = new ResponseEntity<Employee>(emp1,HttpStatus.BAD_REQUEST);
			
		}
		return res;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="empUpdate")
	public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee empToUpdate)
	{
		ResponseEntity<Employee> responseEntity=null;
		Employee em=new Employee();
		service=ContextFactory.getContext().getBean(CMSServiceImpl.class);
		
		try
		{
			em=service.updateEmployeeDetails(empToUpdate);
			em.setMessage(en.getProperty("Service.EMPLOYEE_UPDATED"));
			responseEntity=new ResponseEntity<Employee>(em, HttpStatus.OK);
			
		}
		
		catch(Exception e)
		{
			Employee e1=new Employee();
			e1.setMessage(en.getProperty("Service.EMPLOYEE_UPDATE_Fail"));
			
			responseEntity=new ResponseEntity<Employee>(e1, HttpStatus.BAD_REQUEST);
		}
		
		
		return responseEntity;
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="employeeAll")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		ResponseEntity<List<Employee>> responseEntity=null;

		List<Employee> allEmployee=new ArrayList<Employee>();
		
		try {
			allEmployee=service.getAllEmployee();
			
			responseEntity = new ResponseEntity<>(allEmployee,HttpStatus.OK);

		}


		catch(Exception exception) 
		{
			Employee emp = new Employee();
			emp.setMessage(en.getProperty("Service.EMPLOYEE_NOT_FOUND"));		
			allEmployee.add(emp);			
			responseEntity = new ResponseEntity<>(allEmployee,HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
		
		}
	@DeleteMapping("/deleteEmployee/{eId}")
	public ResponseEntity<String> deleteEmployeeDetails(@PathVariable Integer eId)
	{
		ResponseEntity<String> responseEntity=null;
		try
		{
			service.deleteEmployeeDetails(eId);
			String message = "Employee Deleted";
			responseEntity = new ResponseEntity<>(message,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String message = "Error present";
			responseEntity = new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
		
		
		return responseEntity;
	}

	
	
//-----------------------------------------ADMIN-----------------------------------------------
	
	@RequestMapping(method=RequestMethod.POST,value="loginAdmin")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin)
	{
		ResponseEntity<Admin> responseEntity=null;

		Admin adm =new Admin();
		
		try{
			adm=service.loginAdmin(admin);
			
			responseEntity =new ResponseEntity<Admin>(adm,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = en.getProperty(e.getMessage());
			Admin adm1 = new Admin();
			adm1.setMessage(error);
			responseEntity = new ResponseEntity<Admin>(adm1,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin)
	{
		ResponseEntity<Admin> responseEntity=null;

		Integer admId=null;
		Admin adm=new Admin();
		try
		{
			admId=service.addAdmin(admin);
			adm.seteId(admId);
			responseEntity =new ResponseEntity<Admin>(adm,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = en.getProperty(e.getMessage());
			Admin adm1 = new Admin();
			adm1.setMessage(error);
			
			responseEntity = new ResponseEntity<Admin>(adm1,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
		
	}
	
	@GetMapping("getAdminById/{empid}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("empid") Integer empid)
	{
		ResponseEntity<Admin> res=null;
		Admin adm=new Admin();
		try{
			adm=service.getAdminById(empid);
			res=new ResponseEntity<Admin>(adm,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = en.getProperty(e.getMessage());
			Admin adm1=new Admin();
			adm1.setMessage(error);
			res = new ResponseEntity<Admin>(adm1,HttpStatus.BAD_REQUEST);
			
		}
		return res;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="admUpdate")
	public ResponseEntity<Admin> updateAdminDetails(@RequestBody Admin admToUpdate)
	{
		ResponseEntity<Admin> responseEntity=null;
		Admin adm=new Admin();
		//service=ContextFactory.getContext().getBean(CMSServiceImpl.class);
		
		try
		{
			adm=service.updateAdminDetails(admToUpdate);
			adm.setMessage(en.getProperty("CMSServiceAPI.SUCCESSFUL"));
			responseEntity=new ResponseEntity<Admin>(adm, HttpStatus.OK);
			
		}
		
		catch(Exception e)
		{
			//String errorMessage=en.getProperty(e.getMessage());
			Admin a1=new Admin();
			a1.setMessage(en.getProperty("CMSServiceAPI.UNSUCCESSFUL"));
			responseEntity=new ResponseEntity<Admin>(a1, HttpStatus.BAD_REQUEST);
		}
		
		
		return responseEntity;
	}

	@DeleteMapping("/deleteAdmin/{eId}")
	public ResponseEntity<String> deleteAdminDetails(@PathVariable Integer eId)
	{
		ResponseEntity<String> responseEntity=null;
		try
		{
			service.deleteAdminDetails(eId);
			String message = "Admin Deleted";
			responseEntity = new ResponseEntity<>(message,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String message = "Error present";
			responseEntity = new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
		
		
		return responseEntity;
	}
	
//---------------------------------CUSTOMER-------------------------------------
	
	
	@RequestMapping(method=RequestMethod.POST, value="addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		ResponseEntity<Customer> responseEntity=null;

		Integer custId=null;
		Customer cus=new Customer();
		try
		{
			custId=service.addCustomer(customer);
			cus.setCustId(custId);
			responseEntity =new ResponseEntity<Customer>(cus,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = en.getProperty(e.getMessage());
			Customer cust= new Customer();
			cust.setMessage(error);
			
			responseEntity = new ResponseEntity<Customer>(cust,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
		
	}
	
	@GetMapping("getCustomerById/{custid}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("custid") Integer custid)
	{
		ResponseEntity<Customer> res=null;
		Customer cust=new Customer();
		try{
			cust=service.getCustomerById(custid);
			res=new ResponseEntity<Customer>(cust,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = en.getProperty(e.getMessage());
			Customer cust1=new Customer();
			cust1.setMessage(error);
			res = new ResponseEntity<Customer>(cust1,HttpStatus.BAD_REQUEST);
			
		}
		return res;
	}
	

	@RequestMapping(method=RequestMethod.PUT, value="custUpdate")
	public ResponseEntity<Customer> updateCustomerDetails(@RequestBody Customer custToUpdate)
	{
		ResponseEntity<Customer> responseEntity=null;
		Customer cust=new Customer();
		//service=ContextFactory.getContext().getBean(CMSServiceImpl.class);
		
		try
		{
			cust=service.updateCustomerDetails(custToUpdate);
			cust.setMessage(en.getProperty("CMSServiceAPI.SUCCESSFUL"));
			responseEntity=new ResponseEntity<Customer>(cust, HttpStatus.OK);
			
		}
		
		catch(Exception e)
		{
			//String errorMessage=en.getProperty(e.getMessage());
			Customer cust1=new Customer();
			cust1.setMessage(en.getProperty("CMSServiceAPI.UNSUCCESSFUL"));
			responseEntity=new ResponseEntity<Customer>(cust1, HttpStatus.BAD_REQUEST);
		}
		
		
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="customerAll")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		
		ResponseEntity<List<Customer>> responseEntity=null;

		List<Customer> allCustomer=new ArrayList<Customer>();
		
		try {
			allCustomer=service.getAllCustomer();
			responseEntity = new ResponseEntity<>(allCustomer,HttpStatus.OK);

		}


		catch(Exception exception) {
			String errorMessage = en.getProperty(exception.getMessage());
			Customer cust = new Customer();
			cust.setMessage(errorMessage);			
			allCustomer.add(cust);			
			responseEntity = new ResponseEntity<>(allCustomer,HttpStatus.BAD_REQUEST);
			

		}

		return responseEntity;

	}
	
	@DeleteMapping("/deleteCustomer/{custId}")
	public ResponseEntity<String> deleteCustomerDetails(@PathVariable Integer custId)
	{
		ResponseEntity<String> responseEntity=null;
		try
		{
			service.deleteCustomer(custId);
			String message = "Customer Deleted";
			responseEntity = new ResponseEntity<>(message,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String message = "Error present";
			responseEntity = new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
		
		
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="submitFeedback")
	public ResponseEntity<String> submitFeedback(@PathVariable Customer customer)
	{
		ResponseEntity<String> responseEntity=null;
		try
		{
			service.submitFeedback(customer);
			String message = "Feedback submitted";
			responseEntity = new ResponseEntity<>(message,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String message = "Feedback not submitted";
			responseEntity = new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
		
		
		return responseEntity;
	}


//-------------------------------TRANSACTION------------------------------------------------
	
	@RequestMapping(method=RequestMethod.PUT, value="tranUpdate")
	public ResponseEntity<Transaction> updateTransactionDetails(@RequestBody Transaction transToUpdate)
	{
		ResponseEntity<Transaction> responseEntity=null;
		Transaction tran=new Transaction();
		service=ContextFactory.getContext().getBean(CMSServiceImpl.class);
		
		try
		{
			tran=service.updateTransactionDetails(transToUpdate);
			tran.setMessage(en.getProperty("CMSServiceAPI.SUCCESSFUL"));
			responseEntity=new ResponseEntity<Transaction>(tran, HttpStatus.OK);
			
		}
		
		catch(Exception e)
		{
			//String errorMessage=en.getProperty(e.getMessage());
			Transaction tran1=new Transaction();
			tran1.setMessage(en.getProperty("CMSServiceAPI.UNSUCCESSFUL"));
			responseEntity=new ResponseEntity<Transaction>(tran1, HttpStatus.BAD_REQUEST);
		}
		
		
		return responseEntity;
	}

	
	
	@RequestMapping(method=RequestMethod.GET, value="transactionSearch/{location}")
	public ResponseEntity<List<Transaction>> searchTransactionByAddress(@PathVariable("location") String location)
	{
		
		ResponseEntity<List<Transaction>> responseEntity=null;

		List<Transaction> searchTransaction=new ArrayList<Transaction>();
		
		try {
			searchTransaction=service.searchTransactionByAddress(location);
			responseEntity = new ResponseEntity<>(searchTransaction,HttpStatus.OK);

		}


		catch(Exception exception) {
			String errorMessage = en.getProperty(exception.getMessage());
			Transaction tran = new Transaction();
			tran.setMessage(errorMessage);			
			searchTransaction.add(tran);			
			responseEntity = new ResponseEntity<>(searchTransaction,HttpStatus.BAD_REQUEST);
			

		}

		return responseEntity;

	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="addTransaction")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction)
	{
		ResponseEntity<Transaction> responseEntity=null;

		Integer tranId=null;
		Transaction tr=new Transaction();
		
		try
		{
			tranId=service.addTransaction(transaction);
			transaction.setBillId(tranId);
//			System.out.println(tranId);
			responseEntity =new ResponseEntity<Transaction>(transaction,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = en.getProperty(e.getMessage());
//			Transaction tran= new Transaction();
			tr.setMessage(error);
			
			responseEntity = new ResponseEntity<Transaction>(tr,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="addTransactionExist")
	public ResponseEntity<Transaction> addTransactionExist(@RequestBody Transaction transaction)
	{
		ResponseEntity<Transaction> responseEntity=null;

		Integer tranId=null;
		Transaction tr=new Transaction();
		
		try
		{
			tranId=service.addTransactionExist(transaction);
			transaction.setBillId(tranId);
//			System.out.println(tranId);
			responseEntity =new ResponseEntity<Transaction>(transaction,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = en.getProperty(e.getMessage());
//			Transaction tran= new Transaction();
			tr.setMessage(error);
			
			responseEntity = new ResponseEntity<Transaction>(tr,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
		
	}
	
	
	@GetMapping("getTransactionById/{billId}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable("billId") Integer billId)
	{
		
		ResponseEntity<Transaction> res=null;
		Transaction tran=new Transaction();
		try{
			tran=service.getTransactionById(billId);
			res=new ResponseEntity<Transaction>(tran,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String error = en.getProperty(e.getMessage());
			Transaction tran1=new Transaction();
			tran1.setMessage(error);
			res = new ResponseEntity<Transaction>(tran1,HttpStatus.BAD_REQUEST);
			
		}
		return res;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="transactionAll")
	public ResponseEntity<List<Transaction>> getAllTransaction(){
		
		ResponseEntity<List<Transaction>> responseEntity=null;

		List<Transaction> allTransaction=new ArrayList<Transaction>();
		
		try {
			allTransaction=service.getAllTransaction();
			responseEntity = new ResponseEntity<>(allTransaction,HttpStatus.OK);

		}


		catch(Exception exception) 
		{
			String errorMessage = en.getProperty(exception.getMessage());
			Transaction tran = new Transaction();
			tran.setMessage(errorMessage);			
			allTransaction.add(tran);			
			responseEntity = new ResponseEntity<>(allTransaction,HttpStatus.BAD_REQUEST);
			

		}

		return responseEntity;

	}
	
	@DeleteMapping("/deleteTransaction/{tranId}")
	public ResponseEntity<String> deleteTransactionDetails(@PathVariable Integer tranId)
	{
		ResponseEntity<String> responseEntity=null;
		try
		{
			service.deleteTransactionDetails(tranId);
			String message = "Transaction Deleted";
			responseEntity = new ResponseEntity<>(message,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String message = "Error present";
			responseEntity = new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
		
		
		return responseEntity;
	}
	

//--------------------------------------Contact---------------------------------------------------------------

@RequestMapping(method=RequestMethod.POST, value="addContact")
public ResponseEntity<Contact> addContact(@RequestBody Contact contact)
{
	ResponseEntity<Contact> responseEntity=null;

	Integer contactId=null;
	Contact con=new Contact();
	try
	{
		contactId=service.addContact(contact);
		contact.setContactId(contactId);
		responseEntity =new ResponseEntity<Contact>(contact,HttpStatus.OK);
	}
	catch(Exception e)
	{
		String error = en.getProperty(e.getMessage());
		Contact cont= new Contact();
		cont.setMessage(error);
		
		responseEntity = new ResponseEntity<Contact>(cont,HttpStatus.BAD_REQUEST);
		
	}
	return responseEntity;
	
}

@GetMapping("getContactById/{contactId}")
public ResponseEntity<Contact> getContactById(@PathVariable("contactId") Integer contactId)
{
	ResponseEntity<Contact> res=null;
	Contact cont=new Contact();
	try{
		cont=service.getContactById(contactId);
		res=new ResponseEntity<Contact>(cont,HttpStatus.OK);
	}
	catch(Exception e)
	{
		String error = en.getProperty(e.getMessage());
		Contact cont1=new Contact();
		cont1.setMessage(error);
		res = new ResponseEntity<Contact>(cont1,HttpStatus.BAD_REQUEST);
		
	}
	return res;
}

@RequestMapping(method=RequestMethod.POST, value="contUpdate")
public ResponseEntity<Contact> updateContactDetails(@RequestBody Contact contToUpdate)
{
	ResponseEntity<Contact> responseEntity=null;
	Contact cont=new Contact();
	//service=ContextFactory.getContext().getBean(CMSServiceImpl.class);
	
	try
	{
		cont=service.updateContactDetails(contToUpdate);
		cont.setMessage(en.getProperty("CMSServiceAPI.SUCCESSFUL"));
		responseEntity=new ResponseEntity<Contact>(cont, HttpStatus.OK);
		
	}
	
	catch(Exception e)
	{
		//String errorMessage=en.getProperty(e.getMessage());
		Contact cont1=new Contact();
		cont1.setMessage(en.getProperty("CMSServiceAPI.UNSUCCESSFUL"));
		responseEntity=new ResponseEntity<Contact>(cont1, HttpStatus.BAD_REQUEST);
	}
	
	
	return responseEntity;
}

@DeleteMapping("/deleteContact/{contactId}")
public ResponseEntity<String> deleteContactDetails(@PathVariable Integer contactId)
{
	ResponseEntity<String> responseEntity=null;
	try
	{
		service.deleteContactDetails(contactId);
		String message = "Contact Deleted";
		responseEntity = new ResponseEntity<>(message,HttpStatus.OK);
	}
	catch(Exception e)
	{
		String message = "Error present";
		responseEntity = new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
	}
	
	
	return responseEntity;
}


}

