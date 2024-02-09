package banking;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private Map<Long, Account> accounts;
    private AtomicLong nextAccountNumber;
    private Lock lock;

    public Bank() {
        this.accounts = new HashMap<>();
        this.nextAccountNumber = new AtomicLong(0);
        lock = new ReentrantLock();
    }

    private Account getAccount(Long accountNumber) {
        return accounts.get(accountNumber);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
    	Long accountNumber;
    	try {
        	lock.lock();
        	accountNumber = nextAccountNumber.incrementAndGet();
        } finally {
        	lock.unlock();
        }
    	
    	CommercialAccount account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
    	accounts.put(accountNumber, account);
        return accountNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
    	Long accountNumber;
    	try {
        	lock.lock();
        	accountNumber = nextAccountNumber.incrementAndGet();
        } finally {
        	lock.unlock();
        }
    	
    	ConsumerAccount account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
    	accounts.put(accountNumber, account);
        return accountNumber;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        Account account = getAccount(accountNumber);
        if (account != null) {
        	return account.validatePin(pin);
        }
        return false;
    }

    public double getBalance(Long accountNumber) {
    	Account account = getAccount(accountNumber);
        if (account != null) {
        	return account.getBalance();
        }
        return -1;
    }

    public void credit(Long accountNumber, double amount) {
    	Account account = getAccount(accountNumber);
        if (account != null) {
        	account.creditAccount(amount);
        }
    }

    public boolean debit(Long accountNumber, double amount) {
    	Account account = getAccount(accountNumber);
        if (account != null) {
        	return account.debitAccount(amount);
        }
        return false;
    }
}
