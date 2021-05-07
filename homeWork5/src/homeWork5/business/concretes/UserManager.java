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
			System.out.println("�ifre en az 6 karakter olmal�d�r");
			return;
		}                                                         
			String regex ="^[A-Za-z0-9+_.-]+@(.+)$";
			   Pattern pattern = Pattern.compile(regex);
		       Matcher matcher = pattern.matcher(user.getEmail());
		        if (!matcher.matches()) {
		            System.out.println("Mail adresi e posta format�nda olmal�d�r(example@example.com)");
		            return;
		        }
		        if (userDao.getMail(user.getEmail()) != null){
		            System.out.println("Bu kullan�c� zaten mevcut");
		            return  ;
		        }
		        if (user.getFirstName().length() < 2 || user.getLastName().length() < 2){
		            System.out.println("�sim, Soyisim 2 karakterden uzun olmal�d�r");
		            return  ;
		        }
		       
		        	
		        	if(verifyManager.verify()) {
		        		System.out.println("Do�rulama e-postas� g�nderildi");
		        		System.out.println("�yelik tamamland�");
		        	System.out.println("Ba�ar�yla kaydoldunuz : "+user.getFirstName());
		        	accountService.register(user.getEmail());
		        	
		        	}
		        	else
		        	{
		        		System.out.println("Hata do�rulama yap�lamad� : "+user.getFirstName());
		        	}
	}

	@Override
	public void login(User user) {
		 if (user.getEmail() == null || user.getPassword() == null){
	            System.out.println("Hatal� giri�");
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
