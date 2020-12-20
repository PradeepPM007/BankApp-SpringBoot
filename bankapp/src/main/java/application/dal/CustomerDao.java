package application.dal;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.Customer;
import application.entity.User;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long>,DefaultDao{
	
	Customer findByApplicationId(String applicationId);
	
	void deleteByApplicationId(String applicationId);
	List<Customer> findByUsername(User username);
	
}
