package com.jayasanka.codility;

import com.jayasanka.codility.bank.Account;
import com.jayasanka.codility.bank.AccountType;
import com.jayasanka.codility.bank.Bank;
import com.jayasanka.codility.bank.Customer;
import com.jayasanka.codility.bank.account.ThreadSafeLockSavingsAccount;

public class OnlineBankingApp {
	
	public static void main(String[] args) {
		Bank bank = new Bank("DBS", "SG");
		Customer jayasanka = new Customer("Jayasanka");
		final Account acc = new ThreadSafeLockSavingsAccount(bank, AccountType.SAVINGS, jayasanka, 100);
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Your balance after deposit: " + acc.deposit(20));
				System.out.println("Your balance after withdraw: " + acc.withdraw(20));
			}
		}, "User1");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Your balance after deposit: " + acc.deposit(20));
				System.out.println("Your balance after withdraw: " + acc.withdraw(20));
			}
		}, "User2");
		
		
		t1.start();
		t2.start();
	}
}
