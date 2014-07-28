package book30.ch11.txAttributes.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import book30.ch11.txAttributes.domain.Account;
import book30.ch11.txAttributes.service.AccountService;

public class BasicTransferTest {
	private static final String fromAccountNumber = "ACC01";
	private static final String toAccountNumber = "ACC02";
	
	public static void main(String[] args) {
		System.out.println("************** BEGINNING PROGRAM **************");
		 
		ApplicationContext context = new GenericXmlApplicationContext("book30/ch11/txAttributes/applicationContext.xml");
		AccountService accountService = (AccountService)context.getBean("accountService");
		 
		System.out.println("Creating new accounts " + fromAccountNumber + " and " + toAccountNumber);
		Account fromAccount = new Account(fromAccountNumber,100d);
		Account toAccount = new Account(toAccountNumber,200d);
		accountService.createAccount(fromAccount);
		accountService.createAccount(toAccount);
		printAccountInformation(accountService);
		System.out.println("New accounts created successfully");
		System.out.println("----");
		 
		Double transferAmount;
		
		transferAmount = 50d;
		System.out.println("Transferring " + transferAmount + " from account " + fromAccountNumber + " to account " + toAccountNumber);
		accountService.transferFunds(fromAccount, toAccount, transferAmount);
		printAccountInformation(accountService);
		System.out.println("The amount " + transferAmount + " was transferred successfully");
		System.out.println("----");
		 
		System.out.println("************** ENDING PROGRAM **************");
	}
		 
	private static void printAccountInformation(AccountService accountService){
		Account fromAccount = accountService.getAccount(fromAccountNumber);
		Account toAccount = accountService.getAccount(toAccountNumber);
		Double totalBalance = accountService.getTotalBalance(fromAccountNumber, toAccountNumber);
		System.out.println("Balance in account " + fromAccountNumber + " = " + fromAccount.getBalance());
		System.out.println("Balance in account " + toAccountNumber + " = " + toAccount.getBalance());
		System.out.println("Total Balance in the two accounts " + totalBalance);		
	}	
}