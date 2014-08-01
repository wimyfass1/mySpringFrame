package book30.ch11.txAttributes.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import book30.ch11.txAttributes.domain.Account;

public interface AccountService {
	@Transactional
	public void transferFunds(final Account fromAccount, final Account toAccount, final Double transferAmount);

	@Transactional
	public void createAccount(Account account);
	 
	@Transactional(readOnly=true)
	public Account getAccount(String accountNumber);
	
	@Transactional(readOnly=true, isolation=Isolation.REPEATABLE_READ)
	public Double getTotalBalance(String fromAccountNumber, String toAccountNumber);
}
