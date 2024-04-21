package tn.enicarthage.gestionclub.services;

import tn.enicarthage.gestionclub.entities.User;

public interface IUserService {
	public void initRoleAndUser();
	public User registerNewUser(User user);
	public String getEncodedPassword(String password);
}
