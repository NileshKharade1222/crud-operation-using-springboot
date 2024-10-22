package crud.operation.student.managment.system;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class student {
	
	@Id
	private String id;
	private String name;
	private String lastname;
	private String dob;
	private String gender;
	private String phoneno;
	private String email;
	public student(String id, String name, String lastname, String dob, String gender, String phoneno, String email) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.dob = dob;
		this.gender = gender;
		this.phoneno = phoneno;
		this.email = email;
	}
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", lastname=" + lastname + ", dob=" + dob + ", gender=" + gender
				+ ", phoneno=" + phoneno + ", email=" + email + "]";
	}
	
	
	

}
