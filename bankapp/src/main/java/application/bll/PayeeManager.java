package application.bll;

import java.util.List;

import application.entity.Payee;
import application.entity.User;

public interface PayeeManager extends DefaultManager{

	Payee findPayeeByApplicationId(String applicationId);

	void executeUpdatePayee(Payee payee);

	void executeDeleteByApplicationId(String applicationId);

	List<Payee> findPayeeByUser(User activeUser);

}
