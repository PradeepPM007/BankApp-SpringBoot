package application.bll;

import java.util.List;

import application.entity.Customer;
import application.entity.User;

public interface CustomerManager extends DefaultManager{

	
	public void executeSaveCustomer(Customer customer);

	public List<Customer> findAll();

	public Customer findCutomerOnApplicationId(String applicationId);

	public void executeUpdateCustomer(Customer customer);

	public Customer findOne(long id);

	public  void executeDeleteByApplicationId(String applicationId);

	public List<Customer> findCustomerByUser(User activeUser); 
}