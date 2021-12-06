package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="activity_area")
public class ActivityArea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToMany(mappedBy="activityArea", cascade=CascadeType.ALL)
	private Set<Employee> employees = new HashSet<Employee>();
	
	
	@ManyToMany(mappedBy = "activityAreas")
	private Set<Affiliate> affiliates = new HashSet<Affiliate>();
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location activityLocation;
	
	

	public void addEmployee(Employee e) {
		this.employees.add(e);
	}
	
	public void addAffiliate(Affiliate a) {
		this.affiliates.add(a);
	}
	
	// Getters/Setters block
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Affiliate> getAffiliates() {
		return affiliates;
	}

	public void setAffiliates(Set<Affiliate> affiliates) {
		this.affiliates = affiliates;
	}

	public Location getLocation() {
		return activityLocation;
	}

	public void setLocation(Location location) {
		this.activityLocation = location;
	}

}
