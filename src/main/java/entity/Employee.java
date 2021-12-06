package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String firstname;
	private String lastname;
	private String email;
	private int age;
	private String roleTitle;
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name="activity_area_id")
	private ActivityArea activityArea;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;
	
	
	
	/**
	 * Default constructor
	 */
	public Employee() {
		super();
		this.id = -1;
		this.age = -1;
	}
	
	
	// Getters/Setters block
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) throws IllegalArgumentException {
		if (age<=0)
			throw new IllegalArgumentException("Employee : Age can't be under or equal to zero.");
		else
			this.age = age;
	}
	
	public String getRoleTitle() {
		return roleTitle;
	}
	
	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public ActivityArea getActivityArea() {
		return activityArea;
	}


	public void setActivityArea(ActivityArea activityArea) {
		this.activityArea = activityArea;
	}
	
}
