package application.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
@MappedSuperclass
public class AbstractEmployee implements Domain{

	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
	  
	  	private String applicationId;

	    private String name;

	    private Double salary;

	    private String email;

	    private String phone;

	    @OneToOne
	    @JoinColumn(name = "user_id")
	    private User username;

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Double getSalary() {
	        return salary;
	    }

	    public void setSalary(Double salary) {
	        this.salary = salary;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public User getUsername() {
	        return username;
	    }

	    public void setUsername(User username) {
	        this.username = username;
	    }

		public String getApplicationId() {
			return applicationId;
		}

		public void setApplicationId(String applicationId) {
			this.applicationId = applicationId;
		}
}