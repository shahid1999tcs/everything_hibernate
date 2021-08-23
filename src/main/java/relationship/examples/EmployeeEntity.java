package relationship.examples;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	private String name;
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn //For shared primary key OneToOne
	private AccountEntity account;
	
//	@OneToMany(cascade=CascadeType.ALL)
//    @JoinColumn(name="EMPLOYEE_ID")
//	private Set<AccountEntity> accounts;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

//	public Set<AccountEntity> getAccounts() {
//		return accounts;
//	}
//
//	public void setAccounts(Set<AccountEntity> accounts) {
//		this.accounts = accounts;
//	}
	
	
	
}
