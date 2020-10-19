package sn.forage.dao;

import sn.forage.entities.Client;
import sn.forage.web.EntityMana;

public class ClientImpl implements IClient {
	
	
	@Override
	public int insertClient(Client client) {
		int val ;
		try {
			EntityMana.insert(client);
			val =1 ;
		} catch (Exception e) {
			val =0;
		}
		
		return val;
	}

}
