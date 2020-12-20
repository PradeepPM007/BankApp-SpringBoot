package application.bll.support;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import application.bll.CustomerManager;
import application.bll.PayeeManager;
import application.dal.AccountDao;
import application.dal.PayeeDao;
import application.entity.Customer;
import application.entity.Domain;
import application.entity.Payee;
import application.entity.User;
@Service
@Transactional
public class PayeeManagerImpl extends DefaultManagerImpl implements PayeeManager{

	@Autowired
	CustomerManager customerManager;
	
	@Autowired @Lazy
	public void setDefaultDao(PayeeDao defaultDao) {
		this.defaultDao = defaultDao;
	}

	private PayeeDao getPayeeDao() {
		return (PayeeDao) getDefaultDao();
	}

	
	@Override
	public Payee findPayeeByApplicationId(String applicationId) {
		return getPayeeDao().findByApplicationId(applicationId);
	}

	@Override
	public void executeUpdatePayee(Payee payee) {
		getPayeeDao().save(payee);
	}

	@Override
	public void executeDeleteByApplicationId(String applicationId) {
		getPayeeDao().deleteByApplicationId(applicationId);
	}

	@Override
	public List<Payee> findPayeeByUser(User user) {
		Customer customer = null;
		List<Customer> customers = (List<Customer>) customerManager.findCustomerByUser(user);
		if(!CollectionUtils.isEmpty(customers)) {
			 customer = customers.iterator().next();
		}
		return getPayeeDao().findByOwner(customer);
	}
	
	
}
