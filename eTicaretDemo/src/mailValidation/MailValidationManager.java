package mailValidation;

public class MailValidationManager {
	
	
	
	public void sendMail(String eMail) {
		
		System.out.println(eMail+ " Adresine Doğrulama maili gönderilmiştir.");
		
		
	};
	
	public boolean checkifMailClicked(String eMail)  {
		System.out.println(eMail+" Adresinde doğrulama mailine tıklandı ve doğrulama gerçekleştirildi.");
		return true;
	}
	
	

}
