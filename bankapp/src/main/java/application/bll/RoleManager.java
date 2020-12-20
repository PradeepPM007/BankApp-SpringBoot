package application.bll;

import application.entity.Role;

public interface RoleManager extends DefaultManager{

	Role findByRole(String parameter);

}
