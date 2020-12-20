package application.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.Role;
@Repository
public interface RoleDao extends JpaRepository<Role,Long>,DefaultDao{
	Role findByRole(String role);
}
