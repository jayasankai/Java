package banking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Abstract bank account class.<br>
 * <br>
 * <p>
 * Private Variables:<br>
 * {@link #accountHolder}: AccountHolder<br>
 * {@link #accountNumber}: Long<br>
 * {@link #pin}: int<br>
 * {@link #balance}: double
 */
public abstract class Account implements AccountInterface {
    private AccountHolder accountHolder;
    private Long accountNumber;
    private int pin;
    private double balance;
    
    private Lock lock;

    protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
    	this.accountHolder = accountHolder;
    	this.accountNumber = accountNumber;
    	this.pin = pin;
    	this.balance = startingDeposit;
    	
    	this.lock = new ReentrantLock();
    }

    public AccountHolder getAccountHolder() {
        return this.accountHolder;
    }

    public boolean validatePin(int attemptedPin) {
        if (this.pin == attemptedPin) {
        	return true;
        	
        }
        return false;
    }

    public double getBalance() {
        return this.balance;
    }

    public Long getAccountNumber() {
        return this.accountNumber;
    }

    public void creditAccount(double amount) {
    	try {			
    		lock.lock();
    		this.balance = this.balance + amount;
		} finally {
			lock.unlock();
		}
    }

    public boolean debitAccount(double amount) {
    	try {			
    		lock.lock();
    		if (amount > this.balance) {
    			return false;
    		} else {
    			this.balance = this.balance - amount;
    			return true;
    		}
    	} finally {
    		lock.unlock();
    	}
    }
}
