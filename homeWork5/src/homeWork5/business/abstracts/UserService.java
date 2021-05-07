package homeWork5.business.abstracts;

import homeWork5.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(User user);
	User getMail(String mail);

}
