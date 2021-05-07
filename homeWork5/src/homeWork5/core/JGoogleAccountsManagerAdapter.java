package homeWork5.core;


import jGoogleAccounts.JGoogleAccountsManager;

public class JGoogleAccountsManagerAdapter implements AccountService{
	
	@Override
	public void register(String message) {
		JGoogleAccountsManager google =new  JGoogleAccountsManager();
		
		google.registerGoogle(message);
		
	}
	
	

}
