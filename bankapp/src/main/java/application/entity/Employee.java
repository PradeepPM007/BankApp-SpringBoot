package application.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "employee")
public class Employee extends AbstractEmployee{

	public Employee() {
		 super();
    }

  
}