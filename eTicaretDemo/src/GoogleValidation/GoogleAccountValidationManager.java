package GoogleValidation;

public class GoogleAccountValidationManager {
	
	
	
	public void sendToGoogleAccount(String googleAccount) {
		
		System.out.println(googleAccount + "Google hesabına doğrulama maili gönderildi");
	}
	
	public boolean checkGoogleAccountValidate(String googleAccount) {
		
		System.out.println(googleAccount+"Adresinde doğrulama mailine tıklandı ve doğrulama gerçekleştirildi.");
		return true;
		
	}
	
	
	

}
