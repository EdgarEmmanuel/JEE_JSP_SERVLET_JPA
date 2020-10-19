package sn.forage.dao;

import javax.persistence.EntityManager;

import sn.forage.entities.User;
import sn.forage.web.EntityMana;

public class UserImpl implements IUser {
	
	private EntityManager em;
	
	public  UserImpl() {
		em = EntityMana.getManager();
	}

	@Override
	public User getUserByParams(String login, String password) {
		User user = null;
		try {
			 user = (User) em.createQuery("SELECT c FROM User c where c.email=:email and c.pasword=:password",User.class)
				.setParameter("email", login)
				.setParameter("password", password)
				.getSingleResult();
		} catch (Exception e) {
			user = null;
		}
		return user;
	}

}
