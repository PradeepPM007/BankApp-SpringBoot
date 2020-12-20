package application.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.Log;
import application.entity.User;
@Repository
public interface LogDao extends JpaRepository<Log,Long>,DefaultDao{

	List<Log> findByUser(User activeUser);

}
