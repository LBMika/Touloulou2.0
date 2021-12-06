package manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entity.ActivityArea;
import entity.Affiliate;
import entity.Company;
import entity.Employee;
import entity.Location;

public class TouloulouManager {
	public static void main(String[] args) {
		// Getting session factory
		SessionFactory sessionFactory;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();


		// Locations
		Location loc1 = new Location();
		loc1.setTown("TouloulouVille");
		loc1.setZipcode("12345");
		loc1.setAddress("3 rue de la malice");
		Location loc2 = new Location();
		loc2.setTown("AlphaBeta");
		loc2.setZipcode("56789");
		loc2.setAddress("Avenue du travail forcé");
		Location loc3 = new Location();
		loc3.setTown("Nowhere");
		loc3.setZipcode("66666");
		loc3.setAddress("Boulevard de la joie");
		
		// Company
		Company company = new Company();
		company.setName("EsclavesNCO");
		
		// Affiliates
		Affiliate aff1 = new Affiliate();
		aff1.setName("Cacao stuff");
		Affiliate aff2 = new Affiliate();
		aff2.setName("Sugar stuff");
		Affiliate aff3 = new Affiliate();
		aff3.setName("Cotton stuff");
		
		// Activities area
		ActivityArea area1 = new ActivityArea();
		area1.setName("Cotton");
		ActivityArea area2 = new ActivityArea();
		area2.setName("Esclavage");
		ActivityArea area3 = new ActivityArea();
		area3.setName("Food");
		ActivityArea area4 = new ActivityArea();
		area4.setName("Child labor");
		ActivityArea area5 = new ActivityArea();
		area5.setName("Profits");
		
		// Employees
		Employee employee1 = new Employee();
		employee1.setAge(12);
		employee1.setEmail("ljkhgfd@lhg.fr");
		employee1.setFirstname("Toto");
		employee1.setLastname("Titi");
		employee1.setRoleTitle("Exploted child");
		employee1.setPhoneNumber("0323232323");
		Employee employee2 = new Employee();
		employee2.setAge(33);
		employee2.setEmail("ttttttt@rrrrrrrrr.fr");
		employee2.setFirstname("Alpha");
		employee2.setLastname("Beta");
		employee2.setRoleTitle("Another one");
		employee2.setPhoneNumber("0123343569");
		Employee employee3 = new Employee();
		employee3.setAge(56);
		employee3.setEmail("bigboss@greedy.com");
		employee3.setFirstname("Activision");
		employee3.setLastname("Blizzard");
		employee3.setRoleTitle("The Big One");
		employee3.setPhoneNumber("0666666666");
		
		
		// Binding locations
		loc1.addEmployee(employee1);
		loc1.addActivityArea(area1);
		loc1.addActivityArea(area2);
		loc2.addEmployee(employee2);
		loc2.addActivityArea(area3);
		loc2.addActivityArea(area4);
		loc3.addEmployee(employee3);
		loc3.addActivityArea(area5);
		
		// Binding employees
		employee1.setLocation(loc1);
		employee1.setActivityArea(area4);
		employee2.setLocation(loc2);
		employee2.setActivityArea(area3);	
		employee3.setLocation(loc3);
		employee3.setActivityArea(area5);
		
		// Binding company
		company.addAffiliate(aff1);
		company.addAffiliate(aff2);
		company.addAffiliate(aff3);
		
		// Binding affiliates
		aff1.setCompany(company);
		aff1.addActivityArea(area2);
		aff1.addActivityArea(area3);
		aff1.addActivityArea(area4);
		aff1.addActivityArea(area5);
		
		aff2.setCompany(company);
		aff2.addActivityArea(area2);
		aff2.addActivityArea(area3);
		aff2.addActivityArea(area4);
		aff2.addActivityArea(area5);
		
		aff3.setCompany(company);
		aff3.addActivityArea(area1);
		aff3.addActivityArea(area2);
		aff3.addActivityArea(area4);
		aff3.addActivityArea(area5);
		
		// Binding activity areas
		area1.setLocation(loc1);
		area2.setLocation(loc2);
		area3.setLocation(loc1);
		area4.setLocation(loc2);
		area5.setLocation(loc3);
		
		area4.addEmployee(employee1);
		area3.addEmployee(employee2);
		area5.addEmployee(employee3);
		area1.addAffiliate(aff3);
		area2.addAffiliate(aff1);
		area2.addAffiliate(aff2);
		area2.addAffiliate(aff3);
		area3.addAffiliate(aff1);
		area3.addAffiliate(aff2);
		area4.addAffiliate(aff1);
		area4.addAffiliate(aff2);
		area4.addAffiliate(aff3);
		area5.addAffiliate(aff1);
		area5.addAffiliate(aff2);
		area5.addAffiliate(aff3);

		

		// Saving
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		/*
		session.save(aff1);
		session.save(aff2);
		session.save(aff3);
		*/
		// session.save(company);
		session.save(loc1);
		session.save(loc2);
		session.save(loc3);
		
		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}	
	
}
