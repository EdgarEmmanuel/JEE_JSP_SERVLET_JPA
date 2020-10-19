package sn.forage.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.forage.entities.Statut;
import sn.forage.entities.User;
import sn.forage.entities.Village;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JEE_JSP_SERVLET_JPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		User user = new User();
		user.setEmail("admin@gmail.com");
		user.setNom("seck");
		user.setPasword("passer");
		user.setPrenom("Seck");
		user.setStatut(em.find(Statut.class, 1));
		
		
		
		em.persist(user);
		
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
