package book30.ch06._8._3.service;

import java.util.List;
import book30.ch06.domain.User;

public interface UserService {
	void add(User user);
	void deleteAll();
	void update(User user);	
	void upgradeLevels();
	
	User get(String id);

	List<User> getAll();
}
