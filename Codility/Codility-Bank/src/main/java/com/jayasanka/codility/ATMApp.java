package com.jayasanka.codility;

import com.jayasanka.codility.bank.Account;
import com.jayasanka.codility.bank.AccountType;
import com.jayasanka.codility.bank.Bank;
import com.jayasanka.codility.bank.Customer;
import com.jayasanka.codility.bank.account.SimpleSavingsAccount;

public class ATMApp {
	public static void main(String[] args) {
		Bank bank = new Bank("DBS", "SG");
		Customer jayasanka = new Customer("Jayasanka");
		Account acc = new SimpleSavingsAccount(bank, AccountType.SAVINGS, jayasanka, 100);
		
		acc.deposit(20);
		acc.withdraw(20);
		
		acc.deposit(20);
		acc.withdraw(20);		
	}
}
