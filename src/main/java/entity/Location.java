package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String town;
	private String zipcode;
	private String address;
	
	@OneToMany(mappedBy="location", cascade=CascadeType.ALL)
	private Set<ActivityArea> activityAreas = new HashSet<ActivityArea>();
	
	@OneToMany(mappedBy="location", cascade=CascadeType.ALL)
	private Set<Employee> employees = new HashSet<Employee>();
	
	
	public void addActivityArea(ActivityArea a) {
		this.activityAreas.add(a);
	}
	
	public void addEmployee(Employee e) {
		this.employees.add(e);
	}
	

	// Getters/Setters block
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTown() {
		return town;
	}
	
	public void setTown(String town) {
		this.town = town;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public Set<ActivityArea> getActivityAreas() {
		return activityAreas;
	}

	public void setActivityAreas(Set<ActivityArea> activityAreas) {
		this.activityAreas = activityAreas;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
}
