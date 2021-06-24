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
        User user5 = new User (5,"Muhammed","Argýn","yorgunargin@outlook.com","1598753");
        UserDao userDao = new HibernateUserDao();
        UserService userService = new UserManager(new GoogleValidationAdapter(),userDao , new UserCheckManager(userDao));
        
        userService.register(user5);
        
        //sýrasýyla nullCheck,nameAndSurnameCheck,regexMailCheck,passwordLenghtCheck,unusedMailCheck
        //kontrolleri yapýlmaktadýr ve karþýlaþýlan hata olursa kullanýcýya bilgi verilmektedir
        //hatasýz çalýþýr ise sýrasýyla mail gönderilip,doðrulama yapýlmýþ ise database'e kayýt ile register
        //iþlemi sonlanmaktadýr.
       
         userService.login(user5.getEmail(),user5.getPassword());
         // kullanýcý giriþi yapýlýrken mail ve þifre alanlarýnýn boþ olup olmadýðýo kontrol edilmekte
        
	}

}
