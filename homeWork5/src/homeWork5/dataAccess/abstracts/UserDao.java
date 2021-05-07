package homeWork5.dataAccess.abstracts;

import homeWork5.entities.concretes.User;

public interface UserDao {
	void register(User user);
	void login(User user);
	void delete(User user);
	User getMail(String mail);

}
