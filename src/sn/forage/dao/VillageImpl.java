package sn.forage.dao;

import javax.persistence.EntityManager;

import sn.forage.entities.Village;
import sn.forage.web.EntityMana;

public class VillageImpl implements IVillage {
	private EntityManager em;
	 public VillageImpl() {
		em = EntityMana.getManager();
	}

	@Override
	public int insertVillage(Village vl) {
		int val;
		try {
			EntityMana.insert(vl);
			val = 1;
		} catch (Exception e) {
			val =0;
		}
		return val;
	}

}
