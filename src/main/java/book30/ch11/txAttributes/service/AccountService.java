package book30.ch11.txAttributes.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import book30.ch11.txAttributes.dao.AccountDao;
import book30.ch11.txAttributes.domain.Account;

public interface AccountService {
	public AccountDao getAccountDao();
	
	public void setAccountDao(AccountDao accountDao);
	 
	public void create(Account account);
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void transferFunds(final Account fromAccount, final Account toAccount, final Double transferAmount);
	 
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor=Exception.class)
	public void transferFundsException(final Account fromAccount, final Account toAccount, final Double transferAmount) throws Exception;
	 
	public void createAccount(Account account);
	 
	public Account getAccount(String accountNumber);
}
