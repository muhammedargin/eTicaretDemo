package eTicaretDemo.business.concretes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTicaretDemo.business.abstracts.UserCheckService;
import eTicaretDemo.dataAccess.abstracts.UserDao;
import eTicaretDemo.entities.concretes.User;

public class UserCheckManager implements UserCheckService {
    UserDao userDao ; //kontrol servisimize hangi veritaban�ndan kontrol yapaca��n� s�yl�yoruz
    
    public UserCheckManager(UserDao userDao) {
		this.userDao =userDao;
	}
	@Override
	public boolean nullCheck(User user) {
		//id sistem taraf�ndan atand��� i�in onun bo�luk kontrol� yap�lmam��t�r
		if (user.getFirstName().equals(null) || user.getLastName().equals(null) || user.getEmail().equals(null) 
				|| user.getPassword().equals(null) )
		{
			return false; 
		}
		else {
			return true;
		}
		
	}

	@Override
	public boolean passwordLengthCheck(User user) {
		if (user.getPassword().length()<6) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public boolean regexMailCheck(User user) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		if (matcher.matches()==true) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean unusedMailCheck(User user) {
			for (User userBeingRead : userDao.getAll()) {
			
			if (user.getEmail() == userBeingRead.getEmail()) {
				
				//mailin daha �nce kullan�ld��� durumda false d�nd�r�yor
				return false;
			}
			
			
		}
			return true;
			
	}

	@Override
	public boolean nameAndSurnameCheck(User user) {
		if (user.getFirstName().length()<2 || user.getLastName().length()<2  ) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
}

	
	
	


