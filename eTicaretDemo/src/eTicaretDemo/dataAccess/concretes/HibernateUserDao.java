package eTicaretDemo.dataAccess.concretes;
import java.util.ArrayList;
import eTicaretDemo.dataAccess.abstracts.UserDao;
import eTicaretDemo.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	//inmemory çalýþýldý
    ArrayList<User> users;
   
    public HibernateUserDao() {
    	User user1 =new User (1,"Ahmet","Mehmet","ahmetmehmet@hotmail.com","123456");
		User user2 =new User (2,"Hasan","Hüseyin","hasanhüseyin@hotmail.com","qwerty");
		User user3 =new User (3,"Jale","Hale","jalehale@hotmail.com","asdfgh");
		users=  new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
	
	}
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Hibernate ile eklendi "+ user.getFirstName());
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<User> getAll() {
		
		return users;
	}

}
