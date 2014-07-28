package book30.ch11.txAttributes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import book30.ch11.txAttributes.dao.AccountDao;
import book30.ch11.txAttributes.domain.Account;

public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDao accountDao;
	 
	@Override
	public AccountDao getAccountDao() {
		return accountDao;
	}

	@Override	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	 
	@Override
	public void create(Account account) {
		accountDao.insert(account);
	}
	
	@Override	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void transferFunds(final Account fromAccount, final Account toAccount, final Double transferAmount) {
		fromAccount.debit(transferAmount);
		toAccount.credit(transferAmount);
		accountDao.update(fromAccount);
		accountDao.update(toAccount);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor=Exception.class)
	public void transferFundsException(final Account fromAccount, final Account toAccount, final Double transferAmount) throws Exception {
		fromAccount.debit(transferAmount);
		toAccount.credit(transferAmount);
		accountDao.update(fromAccount);
		accountDao.update(toAccount);
		// Simulate an exception that occurs during funds transfer
		throw new Exception();
	}

	@Override
	public void createAccount(Account account) {
		accountDao.insert(account);
	}

	@Override
	public Account getAccount(String accountNumber) {
		return accountDao.select(accountNumber);
	}
}
