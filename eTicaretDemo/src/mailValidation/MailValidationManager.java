package mailValidation;

public class MailValidationManager {
	
	
	
	public void sendMail(String eMail) {
		
		System.out.println(eMail+ " Adresine Do�rulama maili g�nderilmi�tir.");
		
		
	};
	
	public boolean checkifMailClicked(String eMail)  {
		System.out.println(eMail+" Adresinde do�rulama mailine t�kland� ve do�rulama ger�ekle�tirildi.");
		return true;
	}
	
	

}
