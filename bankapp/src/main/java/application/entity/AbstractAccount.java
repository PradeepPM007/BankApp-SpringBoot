package application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractAccount implements Domain{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(unique = true)
	private String applicationId;
	
    private String type;

    private double balance;

    private Date date;
    
	@Column(unique = true)
    private String accountNo;
    
    @ManyToOne
    private Customer owner;

//	public AbstractAccount(long id, String applicationId, String type, double balance, Date date, String accountNo,
//			Customer owner) {
//		super();
//		this.id = id;
//		this.applicationId = applicationId;
//		this.type = type;
//		this.balance = balance;
//		this.date = date;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
}
