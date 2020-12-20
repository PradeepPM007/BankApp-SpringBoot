package application.bll;

import java.util.List;

import application.entity.Account;
import application.entity.Customer;
import application.entity.User;

public interface AccountManager extends DefaultManager{

	void executeSave(Account account);

	Account findAccountOnApplicationId(String applicationId);

	List<Account> findAll();

	List<Account> findAccountByUser(User activeUser);
	
	Account findAccountOnAccountNo(String accountNo);

}
