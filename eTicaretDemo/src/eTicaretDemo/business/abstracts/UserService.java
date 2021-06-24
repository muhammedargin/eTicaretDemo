package eTicaretDemo.business.abstracts;

import eTicaretDemo.entities.concretes.User;

public interface UserService {
	
	void register(User user);
	void login(String eMail,String password);

}
