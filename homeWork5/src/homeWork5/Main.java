package homeWork5;


import homeWork5.business.abstracts.UserService;
import homeWork5.business.concretes.UserManager;
import homeWork5.business.concretes.VerifyManager;
import homeWork5.core.JGoogleAccountsManagerAdapter;
import homeWork5.dataAccess.concerets.GemiUserDao;
import homeWork5.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user =new User(1,"cihan","gemi","cihan_gemi@hotmail.com","123427");
		User user2=new User();
		user2.setEmail("cihan_gemi@hotmail.com");
		UserService deneme =new UserManager(new GemiUserDao(),new VerifyManager(),new JGoogleAccountsManagerAdapter());
		deneme.register(user);
		deneme.login(user2);
	}

}
