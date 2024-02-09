package banking;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * without generating at runtime, generated list of account numbers and assigned.
 * |AccNo|Status|
 */
public class AccountNumberGenerator {

    // private Long nextAccountNumber = 0L;
    private volatile AtomicLong nextAccountNumber;
    
    Lock lock;

    private AccountNumberGenerator() {
    	lock = new ReentrantLock();
    	nextAccountNumber = new AtomicLong(0);
    }

    private static AccountNumberGenerator ACCOUNT_NUM_GENERATOR;

    public static AccountNumberGenerator getInstance() {
        if (ACCOUNT_NUM_GENERATOR == null) {
            synchronized (AccountNumberGenerator.class) {
                if (ACCOUNT_NUM_GENERATOR == null) {
                    ACCOUNT_NUM_GENERATOR = new AccountNumberGenerator();
                }
            }
        }
        return ACCOUNT_NUM_GENERATOR;
    }

    public Long getNextAccountNumber() {
        try {
        	lock.lock();
            // ++nextAccountNumber;
        	// return nextAccountNumber;
            return nextAccountNumber.incrementAndGet();
        } finally {
        	lock.unlock();
        }
    }


}
