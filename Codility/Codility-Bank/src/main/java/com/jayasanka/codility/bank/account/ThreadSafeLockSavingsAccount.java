package com.jayasanka.codility.bank.account;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.jayasanka.codility.bank.Account;
import com.jayasanka.codility.bank.AccountType;
import com.jayasanka.codility.bank.Bank;
import com.jayasanka.codility.bank.Customer;

public class ThreadSafeLockSavingsAccount extends Account {

	private Lock balanceChangeLock;
	private Condition sufficientFundsCondition;
	
	public ThreadSafeLockSavingsAccount(Customer customer, double initAmount) {
		this.customer = customer;
		this.balance = initAmount;
		
		balanceChangeLock = new ReentrantLock();
		sufficientFundsCondition = balanceChangeLock.newCondition();
	}
	
	public ThreadSafeLockSavingsAccount(Bank bank, AccountType accountType, Customer customer, double initAmount) {
		this.bank = bank;
		this.accountType = accountType;
		this.customer = customer;
		this.balance = initAmount;
		
		balanceChangeLock = new ReentrantLock();
		sufficientFundsCondition = balanceChangeLock.newCondition();
		
	}
	
	@Override
	public double deposit(double amount) {
		balanceChangeLock.lock();
		
		try {
			this.balance = this.balance + amount;
			sufficientFundsCondition.signalAll();
		} finally {
			balanceChangeLock.unlock();
		}
		
		return this.balance;
	}

	@Override
	public double withdraw(double amount) {
		if (this.balance < amount) {
			System.out.println("You can not withdraw " + amount + ", Your balance is: " + this.balance);
		} else {
			balanceChangeLock.lock();
			
			try {				
				this.balance = this.balance - amount;
			} finally {
				balanceChangeLock.unlock();
			}
		}
		
		return this.balance;
	}

}
