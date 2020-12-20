package application.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractPayee implements Domain{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

 	private String applicationId;
 
    private String name;
    
    private String accountNo;
    
    @ManyToOne
    private Customer owner;

//	public AbstractPayee(long id, String applicationId, String name, String accountNo, Customer owner) {
//		super();
//		this.id = id;
//		this.applicationId = applicationId;
//		this.name = name;
//		this.accountNo = accountNo;
//		this.owner = owner;
//	}

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

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}
}
