package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="affiliate")
public class Affiliate {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="activity_area_affiliate", 
			joinColumns = @JoinColumn(name="affiliate_id"),
			inverseJoinColumns = @JoinColumn(name="activity_area_id"))
	private Set<ActivityArea> activityAreas = new HashSet<ActivityArea>();
	
	
	public void addActivityArea(ActivityArea a) {
		this.activityAreas.add(a);
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<ActivityArea> getActivityAreas() {
		return activityAreas;
	}

	public void setActivityAreas(Set<ActivityArea> activityAreas) {
		this.activityAreas = activityAreas;
	}
	
	
}
