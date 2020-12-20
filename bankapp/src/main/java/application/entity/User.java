package application.entity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="UserN")
public class User extends AbstractUser{

    public User() {
    	 super();
    }

}
