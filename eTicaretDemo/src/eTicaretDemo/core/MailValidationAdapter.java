package eTicaretDemo.core;

import mailValidation.MailValidationManager;

public class MailValidationAdapter implements ValidationService{
	
//	MailValidationManager mailValidationManager ;
//	
//	public MailValidationAdapter(MailValidationManager mailValidationManager) {
//		this.mailValidationManager = mailValidationManager;
//	}
	public MailValidationAdapter() {
	
	}	
	@Override
	public void sendMail(String eMail) {
		MailValidationManager mailValidationManager = new MailValidationManager();
		mailValidationManager.sendMail(eMail);//dış servisteki sendMail
		
	}

	@Override
	public boolean checkValidationComplete(String eMail) {
		MailValidationManager mailValidationManager = new MailValidationManager();
		return mailValidationManager.checkifMailClicked(eMail);
		
	} 
	
	

}
