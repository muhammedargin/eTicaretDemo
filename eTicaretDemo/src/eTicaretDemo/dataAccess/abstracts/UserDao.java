package eTicaretDemo.dataAccess.abstracts;

import java.util.ArrayList;

import eTicaretDemo.entities.concretes.User;

public interface UserDao {
	
	void add(User user);
	void delete(User user);
	void update (User user);
	ArrayList<User> getAll();

}
