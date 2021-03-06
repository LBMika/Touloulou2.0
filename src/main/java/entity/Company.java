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
@Table(name="company")
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToMany(mappedBy="company", cascade=CascadeType.ALL)
	private Set<Affiliate> affiliates = new HashSet<Affiliate>();
	
	
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

	public Set<Affiliate> getAffiliates() {
		return affiliates;
	}

	public void setAffiliates(Set<Affiliate> affiliates) {
		this.affiliates = affiliates;
	}
	
}
