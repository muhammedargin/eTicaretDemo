package eTicaretDemo;

import eTicaretDemo.business.abstracts.UserService;
import eTicaretDemo.business.concretes.UserCheckManager;
import eTicaretDemo.business.concretes.UserManager;
import eTicaretDemo.core.GoogleValidationAdapter;
import eTicaretDemo.core.MailValidationAdapter;
import eTicaretDemo.dataAccess.abstracts.UserDao;
import eTicaretDemo.dataAccess.concretes.HibernateUserDao;
import eTicaretDemo.entities.concretes.User;
import mailValidation.MailValidationManager;

public class Main {

	public static void main(String[] args) {
		User user4 =new User (1,"Ahmet","Mehmet","ahmetmehmet@hotmail.com","123456");
        User user5 = new User (5,"Muhammed","Arg�n","yorgunargin@outlook.com","1598753");
        UserDao userDao = new HibernateUserDao();
        UserService userService = new UserManager(new GoogleValidationAdapter(),userDao , new UserCheckManager(userDao));
        
        userService.register(user5);
        
        //s�ras�yla nullCheck,nameAndSurnameCheck,regexMailCheck,passwordLenghtCheck,unusedMailCheck
        //kontrolleri yap�lmaktad�r ve kar��la��lan hata olursa kullan�c�ya bilgi verilmektedir
        //hatas�z �al���r ise s�ras�yla mail g�nderilip,do�rulama yap�lm�� ise database'e kay�t ile register
        //i�lemi sonlanmaktad�r.
       
         userService.login(user5.getEmail(),user5.getPassword());
         // kullan�c� giri�i yap�l�rken mail ve �ifre alanlar�n�n bo� olup olmad���o kontrol edilmekte
        
	}

}
