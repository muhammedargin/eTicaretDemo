package eTicaretDemo.business.concretes;
import eTicaretDemo.business.abstracts.UserCheckService;
import eTicaretDemo.business.abstracts.UserService;
import eTicaretDemo.core.ValidationService;
import eTicaretDemo.dataAccess.abstracts.UserDao;
import eTicaretDemo.entities.concretes.User;

public class UserManager implements UserService {
    ValidationService validationService;//manager'a hangi doðrulama servisiyle çalýþacaksan onu gönderebilirsin çünkü interface
    UserDao userDao;// ayný þekilde hangi veritabaný ile çalýþacaðýný da söyleyebilirsin
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
								System.out.println("Doðrulama mailine týklanmamýþ,doðrulama gerçekleþmemiþtir.");
							}
							
							
						}else {
						System.out.println("Bu mail adresi daha önce kullanýlmýþtýr.Lütfen farklý bir mail kullanýnýz.");
						
						}
					}else {
						System.out.println("Þifreniz 6 karakterden kýsa olamaz.Lütfen kurallar çerçevesinde þifre belirleyiniz");
						
					}
					
				}else {
					
					System.out.println("Yanlýþ bir e-posta adresi girdiniz. Lütfen xxx@example.com standardýnda olmasýna dikkat ediniz");
					
				}
				
			}
			else {
				System.out.println("Ad veye soyad 2 karakterden kýsa olamaz.Tekrar deneyiniz.");
				
			}
		}else {
			System.out.println("Ad,Soyad,E-Mail,Parola alanlarýndan herhangi biri boþ býrakýlamaz,lütfen alanlarý doldurunuz.");
			System.exit(0);//programý burada sonlandýrýr
			
		}
				
			
			
			
		
		

		
		
		
	}

	@Override
	public void login(String eMail, String password) {
		
		if (eMail.equals(null)==true || password.equals(null)==true) {
			 try{ 
			       Thread.sleep(1000); 
			       }catch(InterruptedException e){}
			
			System.out.println("Giriþ yapabilmek için lütfen E-mail ve þifre alanlarýný boþ býrakmayýnýz");
		}
		else {
			 try{ 
			       Thread.sleep(1000); 
			       }catch(InterruptedException e){}
			System.out.println("Kullanýcý giriþi yapýldý");
		}
		
		
	}



}
