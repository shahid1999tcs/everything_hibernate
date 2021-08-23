package fitness;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer ID;
	private String firstName;
	private String lastName;
	private int age;
	private String Address;
	
	@OneToOne
	@JoinColumn(name="APPOINTMENT_ID")
	private AppointmentEntity appoinment;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public AppointmentEntity getAppoinment() {
		return appoinment;
	}

	public void setAppoinment(AppointmentEntity appoinment) {
		this.appoinment = appoinment;
	}
	
}
