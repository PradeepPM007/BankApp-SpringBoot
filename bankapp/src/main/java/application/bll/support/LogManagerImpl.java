package application.bll.support;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bll.LogManager;
import application.dal.LogDao;
import application.entity.Log;
import application.entity.User;
@Service
@Transactional
public class LogManagerImpl extends DefaultManagerImpl implements LogManager{

	@Autowired
	public void setDefaultDao(LogDao defaultDao) {
		this.defaultDao = defaultDao;
	}
	
	private LogDao getLogDao() {
		return (LogDao) getDefaultDao();
	}

	@Override
	public void executeSave(Log log) {
		getLogDao().save(log)	;	
	}

	@Override
	public List<Log> findByUser(User activeUser) {
		// TODO Auto-generated method stub
		return getLogDao().findByUser(activeUser);
	}
	
}