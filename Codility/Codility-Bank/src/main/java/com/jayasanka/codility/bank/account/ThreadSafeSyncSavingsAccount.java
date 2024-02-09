package com.jayasanka.codility.bank.account;

import com.jayasanka.codility.bank.Account;
import com.jayasanka.codility.bank.AccountType;
import com.jayasanka.codility.bank.Bank;
import com.jayasanka.codility.bank.Customer;

public class ThreadSafeSyncSavingsAccount extends Account {

	public ThreadSafeSyncSavingsAccount(Customer customer, double initAmount) {
		this.customer = customer;
		this.balance = initAmount;
	}
	
	public ThreadSafeSyncSavingsAccount(Bank bank, AccountType accountType, Customer customer, double initAmount) {
		this.bank = bank;
		this.accountType = accountType;
		this.customer = customer;
		this.balance = initAmount;
	}
	
	@Override
	public synchronized double deposit(double amount) {
		this.balance = this.balance + amount;
		
		return this.balance;
	}

	@Override
	public synchronized double withdraw(double amount) {
		if (this.balance < amount) {
			System.out.println("You can not withdraw " + amount + ", Your balance is: " + this.balance);
		} else {
			this.balance = this.balance - amount;
			
		}
		
		return this.balance;
	}

}
