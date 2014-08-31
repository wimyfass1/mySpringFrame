package book30.ch05._1._5.dao;

import java.util.List;

import book30.ch05._1._5.domain.User;

public interface UserDao {
	void add(User user);
	User get(String id);
	List<User> getAll();
	void deleteAll();
	int getCount();
	public void update(User user1);
}
