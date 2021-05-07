package homeWork5.business.concretes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import homeWork5.business.abstracts.UserService;
import homeWork5.core.AccountService;
import homeWork5.dataAccess.abstracts.UserDao;
import homeWork5.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userDao;
	private VerifyManager verifyManager;
	private AccountService accountService;

	public UserManager(UserDao userDao,VerifyManager verifyManager,AccountService accountService) {
		this.userDao = userDao;
		this.verifyManager = verifyManager;
		this.accountService = accountService;
	}

	@Override
	public void register(User user) {
		if(user.getPassword().length()<6) {
			System.out.println("Þifre en az 6 karakter olmalýdýr");
			return;
		}                                                         
			String regex ="^[A-Za-z0-9+_.-]+@(.+)$";
			   Pattern pattern = Pattern.compile(regex);
		       Matcher matcher = pattern.matcher(user.getEmail());
		        if (!matcher.matches()) {
		            System.out.println("Mail adresi e posta formatýnda olmalýdýr(example@example.com)");
		            return;
		        }
		        if (userDao.getMail(user.getEmail()) != null){
		            System.out.println("Bu kullanýcý zaten mevcut");
		            return  ;
		        }
		        if (user.getFirstName().length() < 2 || user.getLastName().length() < 2){
		            System.out.println("Ýsim, Soyisim 2 karakterden uzun olmalýdýr");
		            return  ;
		        }
		       
		        	
		        	if(verifyManager.verify()) {
		        		System.out.println("Doðrulama e-postasý gönderildi");
		        		System.out.println("Üyelik tamamlandý");
		        	System.out.println("Baþarýyla kaydoldunuz : "+user.getFirstName());
		        	accountService.register(user.getEmail());
		        	
		        	}
		        	else
		        	{
		        		System.out.println("Hata doðrulama yapýlamadý : "+user.getFirstName());
		        	}
	}

	@Override
	public void login(User user) {
		 if (user.getEmail() == null || user.getPassword() == null){
	            System.out.println("Hatalý giriþ");
	            return;
	        }
		 if (userDao != null){
	            userDao.login(user);
	        }
	       
		
	}

	@Override
	public User getMail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
