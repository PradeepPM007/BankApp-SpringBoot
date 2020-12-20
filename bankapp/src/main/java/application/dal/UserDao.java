package application.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.User;
@Repository
public interface UserDao extends JpaRepository<User,Long>,DefaultDao{

	User findByUsername(String username);

}
