package book30.ch11.txAttributes.dao;

import book30.ch11.txAttributes.domain.Account;

public interface AccountDao {
	public void deleteAll();
	public void insert(Account account);
	public void update(Account account);
	public Account select(String accountNumber);
}
