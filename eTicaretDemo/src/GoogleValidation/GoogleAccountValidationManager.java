package GoogleValidation;

public class GoogleAccountValidationManager {
	
	
	
	public void sendToGoogleAccount(String googleAccount) {
		
		System.out.println(googleAccount + "Google hesab�na do�rulama maili g�nderildi");
	}
	
	public boolean checkGoogleAccountValidate(String googleAccount) {
		
		System.out.println(googleAccount+"Adresinde do�rulama mailine t�kland� ve do�rulama ger�ekle�tirildi.");
		return true;
		
	}
	
	
	

}
