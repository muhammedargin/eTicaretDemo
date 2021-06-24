package eTicaretDemo.core;

import GoogleValidation.GoogleAccountValidationManager;

public class GoogleValidationAdapter implements ValidationService {
    
	
	@Override
	public void sendMail(String eMail) {
		GoogleAccountValidationManager googleAccountValidationManager= new GoogleAccountValidationManager();
		googleAccountValidationManager.sendToGoogleAccount(eMail);
	}

	@Override
	public boolean checkValidationComplete(String eMail) {
		GoogleAccountValidationManager googleAccountValidationManager= new GoogleAccountValidationManager();
		return googleAccountValidationManager.checkGoogleAccountValidate(eMail);
		
	}

}
