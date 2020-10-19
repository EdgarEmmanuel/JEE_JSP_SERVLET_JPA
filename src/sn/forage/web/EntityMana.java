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
}
