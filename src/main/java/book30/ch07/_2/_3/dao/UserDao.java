package book30.ch07._2._3.dao;

import java.util.List;
import book30.ch07.domain.User;

public interface UserDao {
	void add(User user);
	User get(String id);
	List<User> getAll();
	void deleteAll();
	int getCount();
	void update(User user);
}