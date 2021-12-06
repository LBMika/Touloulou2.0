package manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TouloulouManager {
	public static void main(String[] args) {
		// Getting session factory
		SessionFactory sessionFactory;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();


		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}	
	
}
