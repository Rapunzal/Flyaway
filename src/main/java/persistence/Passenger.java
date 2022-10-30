package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PASSENGER")
public class Passenger {
	@Id
	@Column(name="PASSENGER_ID")
	private int passengerId;
	
	@Column(name="FNAME")
	private String fname;
	
	@Column(name="LNAME")
	private String lname;
	
	@Column(name="DOB")
	private String DOB;
	
	@Column(name="ID_NO")
	private String IdentificationNum;
	
	@Column(name="EMAILID")
	private String emailId;
	
	@Column(name="PASSWORD")
	private String password;

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getIdentificationNum() {
		return IdentificationNum;
	}

	public void setIdentificationNum(String identificationNum) {
		IdentificationNum = identificationNum;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
