package sn.forage.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityMana {
	public static EntityManager getManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JEE_JSP_SERVLET_JPA");
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
	public static void insert(Object ok) {
		EntityManager em = EntityMana.getManager();
		em.getTransaction().begin();
		em.persist(ok);
		em.getTransaction().commit();
	}
}
