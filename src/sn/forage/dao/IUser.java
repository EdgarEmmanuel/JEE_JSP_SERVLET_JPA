package sn.forage.dao;

import sn.forage.entities.User;

public interface IUser {
	public User getUserByParams(String login,String password);
}
