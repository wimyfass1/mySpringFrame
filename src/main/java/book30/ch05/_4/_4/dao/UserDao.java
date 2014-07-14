package book30.ch05._4._4.dao;

import java.util.List;
import book30.ch05._4._4.domain.User;

public interface UserDao {
	void add(User user);
	User get(String id);
	List<User> getAll();
	void deleteAll();
	int getCount();
	void update(User user);
}