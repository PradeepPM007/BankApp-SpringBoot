package application.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.Customer;
import application.entity.Payee;
import application.entity.User;

@Repository
public interface PayeeDao extends JpaRepository<Payee,Long>,DefaultDao{

	Payee findByApplicationId(String applicationId);

	List<Payee> findByOwner(Customer activeUser);

	void deleteByApplicationId(String applicationId);

}
