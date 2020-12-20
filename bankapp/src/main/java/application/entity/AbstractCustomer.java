package application.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class AbstractCustomer implements Domain{

	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;

	 	private Boolean isActive;
	 	
	 	@Column(unique = true)
	 	private String applicationId;
	 
	    private String name;

	    private String status;

	    private String email;

	    private String address;
	    
	    @OneToOne
	    @JoinColumn(name = "user_id")
	    private User username;

	    public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getApplicationId() {
			return applicationId;
		}

		public void setApplicationId(String applicationId) {
			this.applicationId = applicationId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Boolean getIsActive() {
			return isActive;
		}

		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}
		
		 public User getUsername() {
		        return username;
		    }

		    public void setUsername(User username) {
		        this.username = username;
		    }
}
