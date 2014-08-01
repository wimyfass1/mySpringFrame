package book30.ch11.txAttributes.service;

import org.springframework.beans.factory.annotation.Autowired;
import book30.ch11.txAttributes.dao.AccountDao;
import book30.ch11.txAttributes.domain.Account;

public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDao accountDao;
	
	@Override	
	public void transferFunds(final Account fromAccount, final Account toAccount, final Double transferAmount) {
		fromAccount.debit(transferAmount);
		toAccount.credit(transferAmount);
		accountDao.update(fromAccount);
		accountDao.update(toAccount);
	}
	
	@Override
	public void createAccount(Account account) {
		accountDao.insert(account);
	}

	@Override
	public Account getAccount(String accountNumber) {
		return accountDao.select(accountNumber);
	}
	
	@Override
	public Double getTotalBalance(String fromAccountNumber, String toAccountNumber) {
		Account fromAccount = accountDao.select(fromAccountNumber);
		Account toAccount = accountDao.select(toAccountNumber);
		return fromAccount.getBalance() + toAccount.getBalance();
	}
}
