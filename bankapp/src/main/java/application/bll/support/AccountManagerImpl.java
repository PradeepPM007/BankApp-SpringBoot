package application.bll.support;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import application.bll.AccountManager;
import application.bll.CustomerManager;
import application.dal.AccountDao;
import application.entity.Account;
import application.entity.Customer;
import application.entity.User;

@Service
@Transactional
public class AccountManagerImpl extends DefaultManagerImpl implements AccountManager{
	
	@Autowired
	CustomerManager customerManager;
	
	@Autowired @Lazy
	public void setDefaultDao(AccountDao defaultDao) {
		this.defaultDao = defaultDao;
	}
	
	private AccountDao getAccountDao() {
		return (AccountDao) getDefaultDao();
	}

	@Override
	public void executeSave(Account account) {
		getAccountDao().save(account);
	}

	@Override
	public Account findAccountOnApplicationId(String applicationId) {
		return getAccountDao().findByApplicationId(applicationId);
	}

	@Override
	public List<Account> findAll() {
		return getAccountDao().findAll();
	}

	@Override
	public List<Account> findAccountByUser(User Owner) {
		Customer customer = null;
		List<Customer> customers = (List<Customer>) customerManager.findCustomerByUser(Owner);
		if(!CollectionUtils.isEmpty(customers)) {
			 customer = customers.iterator().next();
		}
		return getAccountDao().findByOwner(customer);
	}

	@Override
	public Account findAccountOnAccountNo(String accountNo) {
		return getAccountDao().findAccountByAccountNo(accountNo);
	}
}
