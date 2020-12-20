package application.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.Account;
import application.entity.Customer;

@Repository
public interface AccountDao extends JpaRepository<Account,Long>,DefaultDao{

	Account findByApplicationId(String applicationId);

	List<Account> findByOwner(Customer owner);

	Account findAccountByAccountNo(String accountNo);

}
