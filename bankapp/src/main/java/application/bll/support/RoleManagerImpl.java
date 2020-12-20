package application.bll.support;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import application.bll.RoleManager;
import application.dal.AccountDao;
import application.dal.CustomerDao;
import application.dal.RoleDao;
import application.entity.Role;
@Service
@Transactional
public class RoleManagerImpl extends DefaultManagerImpl implements RoleManager{

	@Autowired @Lazy
	public void setDefaultDao(RoleDao defaultDao) {
		this.defaultDao = defaultDao;
	}

	private RoleDao getRoleDao() {
		return (RoleDao) getDefaultDao();
	}
	
	
	@Override
	public Role findByRole(String parameter) {
		return getRoleDao().findByRole(parameter);
	}
}