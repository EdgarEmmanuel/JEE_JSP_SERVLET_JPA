package sn.forage.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.forage.entities.Statut;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JEE_JSP_SERVLET_JPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Statut st = new Statut();
		st.setLibelle("administrateur");
		
		em.persist(st);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
