package eTicaretDemo.business.concretes;
import eTicaretDemo.business.abstracts.UserCheckService;
import eTicaretDemo.business.abstracts.UserService;
import eTicaretDemo.core.ValidationService;
import eTicaretDemo.dataAccess.abstracts.UserDao;
import eTicaretDemo.entities.concretes.User;

public class UserManager implements UserService {
    ValidationService validationService;//manager'a hangi do�rulama servisiyle �al��acaksan onu g�nderebilirsin ��nk� interface
    UserDao userDao;// ayn� �ekilde hangi veritaban� ile �al��aca��n� da s�yleyebilirsin
    UserCheckService userCheckService;
    
    public UserManager(ValidationService validationService,UserDao userDao,UserCheckService userCheckService) {
    	this.validationService =validationService;
    	this.userDao = userDao;
    	this.userCheckService= userCheckService;
		
	}
	@Override
	public void register(User user) {
	    boolean checkResult;
		if (userCheckService.nullCheck(user) ==true) {
			
			if (userCheckService.nameAndSurnameCheck(user)== true ) {
				
				if (userCheckService.regexMailCheck(user)==true) {
					if (userCheckService.passwordLengthCheck(user)==true) {
						if (userCheckService.unusedMailCheck(user) == true) {
							
							validationService.sendMail(user.getEmail());
							 try{ 
							       Thread.sleep(1000); 
							       }catch(InterruptedException e){}
							 
							if (validationService.checkValidationComplete(user.getEmail())) {
								try{ 
								       Thread.sleep(1000); 
								       }catch(InterruptedException e){}
								userDao.add(user);
								
								
							}
							else {
								System.out.println("Do�rulama mailine t�klanmam��,do�rulama ger�ekle�memi�tir.");
							}
							
							
						}else {
						System.out.println("Bu mail adresi daha �nce kullan�lm��t�r.L�tfen farkl� bir mail kullan�n�z.");
						
						}
					}else {
						System.out.println("�ifreniz 6 karakterden k�sa olamaz.L�tfen kurallar �er�evesinde �ifre belirleyiniz");
						
					}
					
				}else {
					
					System.out.println("Yanl�� bir e-posta adresi girdiniz. L�tfen xxx@example.com standard�nda olmas�na dikkat ediniz");
					
				}
				
			}
			else {
				System.out.println("Ad veye soyad 2 karakterden k�sa olamaz.Tekrar deneyiniz.");
				
			}
		}else {
			System.out.println("Ad,Soyad,E-Mail,Parola alanlar�ndan herhangi biri bo� b�rak�lamaz,l�tfen alanlar� doldurunuz.");
			System.exit(0);//program� burada sonland�r�r
			
		}
				
			
			
			
		
		

		
		
		
	}

	@Override
	public void login(String eMail, String password) {
		
		if (eMail.equals(null)==true || password.equals(null)==true) {
			 try{ 
			       Thread.sleep(1000); 
			       }catch(InterruptedException e){}
			
			System.out.println("Giri� yapabilmek i�in l�tfen E-mail ve �ifre alanlar�n� bo� b�rakmay�n�z");
		}
		else {
			 try{ 
			       Thread.sleep(1000); 
			       }catch(InterruptedException e){}
			System.out.println("Kullan�c� giri�i yap�ld�");
		}
		
		
	}



}
