package application.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class AbstractLog implements Domain{

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;

	 	private String applicationId;
	 
	    private Date timestamp;

	    private String operation;

	    @ManyToOne
	    private User user;

	    public String getApplicationId() {
			return applicationId;
		}

		public void setApplicationId(String applicationId) {
			this.applicationId = applicationId;
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}

		public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public Date getTimestamp() {
	        return timestamp;
	    }

	    public void setTimestamp(Timestamp timestamp) {
	        this.timestamp = timestamp;
	    }

	    public String getOperation() {
	        return operation;
	    }

	    public void setOperation(String operation) {
	        this.operation = operation;
	    }

	    public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }
}
