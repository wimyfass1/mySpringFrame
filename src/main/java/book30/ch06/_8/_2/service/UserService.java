package book30.ch06._8._2.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import book30.ch06.domain.User;

@Transactional
public interface UserService {
	void add(User user);
	void deleteAll();
	void update(User user);	
	void upgradeLevels();
	
	@Transactional(readOnly=true)
	User get(String id);

	@Transactional(readOnly=true)
	List<User> getAll();
}
