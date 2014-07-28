package book30.ch11.txAttributes.test;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import book30.ch11.txAttributes.domain.Account;
import book30.ch11.txAttributes.service.AccountService;

public class IsolationTest {
	private static final String accountNumber001 = "ACC01";
	private static final int initalAmountAccount001 = 10000;
	
	private static final String accountNumber002 = "ACC02";
	private static final int initalAmountAccount002 = 20000;
	
	public static void main(String[] args) {
		System.out.println("************** BEGINNING PROGRAM **************");
		 
		ApplicationContext context = new GenericXmlApplicationContext("book30/ch11/txAttributes/applicationContext.xml");
		AccountService accountService = (AccountService)context.getBean("accountService");
		 
		System.out.println("Creating new accounts " + accountNumber001 + " and " + accountNumber002);
		Account fromAccount = new Account(accountNumber001, new Double(initalAmountAccount001));
		Account toAccount = new Account(accountNumber002, new Double(initalAmountAccount002));
		accountService.createAccount(fromAccount);
		accountService.createAccount(toAccount);
		printAccountInformation(accountService);
		System.out.println("New accounts created successfully");
		System.out.println("----");
		 
		TransferThread transferThread = new TransferThread(accountService);
		transferThread.start();
		
		BalanceMonitoThread balanceMonitorThread = new BalanceMonitoThread(accountService);
		balanceMonitorThread.start();
		
		try {
			transferThread.join();
			balanceMonitorThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("************** ENDING PROGRAM **************");
	}
		 
	private static void printAccountInformation(AccountService accountService){
		Account account001 = accountService.getAccount(accountNumber001);
		Account account002 = accountService.getAccount(accountNumber002);
		//Double totalBalance = accountService.getTotalBalance(accountNumber001, accountNumber002);
		System.out.println("Balance in account " + accountNumber001 + " = " + account001.getBalance());
		System.out.println("Balance in account " + accountNumber002 + " = " + account002.getBalance());
		//System.out.println("Total Balance in the two accounts " + totalBalance);		
	}
	
	static class TransferThread extends Thread {
		AccountService accountService;
		Random random;
		Account fromAccount = null;
		Account toAccount = null;
		
		public TransferThread(AccountService accountService) {
			this.accountService = accountService;
			this.random = new Random(System.currentTimeMillis());
		}
		
		public void run() {
			for (int i = 0; i < 100; i++) {
				boolean flag = random.nextBoolean();
				if (flag) {
					fromAccount = accountService.getAccount(accountNumber001);
					toAccount = accountService.getAccount(accountNumber002);
				} else {
					fromAccount = accountService.getAccount(accountNumber002);
					toAccount = accountService.getAccount(accountNumber001);
				}
				int transferAmount = random.nextInt(100);

				System.out.println("Transferring " + transferAmount + " from account " + fromAccount.getNumber() + " to account " + toAccount.getNumber());
				accountService.transferFunds(fromAccount, toAccount, new Double(transferAmount));
				printAccountInformation(accountService);
				System.out.println("The amount " + transferAmount + " was transferred successfully");
				System.out.println("----");
				
				int sleepTime = random.nextInt(10);
				try {
					sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static class BalanceMonitoThread extends Thread {
		AccountService accountService;
		Random random;
		
		public BalanceMonitoThread(AccountService accountService) {
			this.accountService = accountService;
			this.random = new Random(System.currentTimeMillis());
		}
		
		public void run() {
			for (int i = 0; i < 100; i++) {
				Double totalBalance = accountService.getTotalBalance(accountNumber001, accountNumber002);				
				System.out.println("##### Total Balance in the two accounts " + totalBalance + " #####");
				if ((int)totalBalance.doubleValue() != initalAmountAccount001 + initalAmountAccount002) {
					System.out.println("DITRY READ!!!!!");
					System.exit(-1);
				}
				int sleepTime = random.nextInt(20);
				try {
					sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}