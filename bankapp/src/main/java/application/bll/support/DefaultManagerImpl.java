package application.bll.support;

import org.springframework.beans.BeanUtils;

import application.dal.DefaultDao;
import application.entity.Domain;

public class DefaultManagerImpl {

	protected DefaultDao defaultDao;
	
	public void setDefaultDao(DefaultDao defaultDao) {
        this.defaultDao = defaultDao;
    }
    
    public DefaultDao getDefaultDao() {
        return this.defaultDao;
    }
	
	public Domain createNewTransientDomain(String domainClassName) {
		Domain domain;
		try {
			domain = (Domain)BeanUtils.instantiateClass(Class.forName(domainClassName));
		} catch (Exception e) {
			throw new RuntimeException(domainClassName,e);
		} 
		
		return domain;
	}
}
