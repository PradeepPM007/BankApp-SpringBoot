package application.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
@MappedSuperclass
public abstract class AbstractUser implements Domain{

		@GenericGenerator(name="kaugen" , strategy="increment")
		@GeneratedValue(generator="kaugen")
	    @Id
	    private long user_id;

	    @Column(unique = true)
	    private String username;

	    private String password;

	    private String applicationId;
	    
	    private boolean  enabled = true;
	    
	    @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles;

		


	    public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public long getId() {
	        return user_id;
	    }

	    public void setId(long id) {
	        this.user_id = id;
	    }
	    
	    public String getApplicationId() {
			return applicationId;
		}

		public void setApplicationId(String applicationId) {
			this.applicationId = applicationId;
		}

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }


	    public Set<Role> getRoles() {
	        return roles;
	    }

	    public void setRoles(Set<Role> roles) {
	        this.roles = roles;
	    }
}
