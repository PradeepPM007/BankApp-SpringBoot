package application.bll;

import application.entity.Domain;

public interface DefaultManager {

	 Domain createNewTransientDomain(String domainClassName);
}
