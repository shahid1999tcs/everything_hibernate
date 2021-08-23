package fitness;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AppointmentEntity {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer appID;
	private String trainerName;
	
	
	@JoinColumn
	@OneToOne(mappedBy="appoinment")
	private UserEntity user;
	
	private boolean physioRequired;
	private String packageName;
	private int amount;
	

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public boolean isPhysioRequired() {
		return physioRequired;
	}

	public void setPhysioRequired(boolean physioRequired) {
		this.physioRequired = physioRequired;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Integer getAppID() {
		return appID;
	}

	public void setAppID(Integer appID) {
		this.appID = appID;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	

}
