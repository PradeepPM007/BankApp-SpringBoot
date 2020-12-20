package application.bll;

import java.util.List;

import application.entity.Log;
import application.entity.User;

public interface LogManager extends DefaultManager{

	void executeSave(Log log);

	List<Log> findByUser(User activeUser);

}
