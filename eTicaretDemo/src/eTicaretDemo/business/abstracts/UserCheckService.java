package eTicaretDemo.business.abstracts;

import eTicaretDemo.entities.concretes.User;

public interface UserCheckService {
	
	boolean nullCheck(User user);
	boolean nameAndSurnameCheck(User user);
	boolean regexMailCheck(User user);
	boolean passwordLengthCheck(User user);
	boolean unusedMailCheck(User user);
	
	
	

}
