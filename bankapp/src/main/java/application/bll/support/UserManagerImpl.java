package application.bll.support;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import application.bll.UserManager;
import application.dal.AccountDao;
import application.dal.CustomerDao;
import application.dal.UserDao;
import application.entity.User;
@Service
@Transactional
public class UserManagerImpl extends DefaultManagerImpl implements UserManager{

	@Autowired
	public void setDefaultDao(UserDao defaultDao) {
		this.defaultDao = defaultDao;
	}

	private UserDao getUserDao() {
		return (UserDao) getDefaultDao();
	}
	
	@Override
	public void executeSaveUser(User user) {
		getUserDao().save(user);
	}

	@Override
	public User findByUsername(String remoteUser) {
		return getUserDao().findByUsername(remoteUser);
	}
}