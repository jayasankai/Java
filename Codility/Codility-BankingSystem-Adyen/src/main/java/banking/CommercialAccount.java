package banking;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Account implementation for commercial (business) customers.<br><br>
 * <p>
 * Private Variables:<br>
 * {@link #authorizedUsers}: List&lt;Person&gt;<br>
 */
public class CommercialAccount extends Account {
	// Why change to Set --> sync Set
	// Time complexity
    private Set<Person> authorizedUsers;

    public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
        super(company, accountNumber, pin, startingDeposit);
        this.authorizedUsers = Collections.synchronizedSet(new HashSet<>());
    }

    /**
     * @param person The authorized user to add to the account.
     */
    protected void addAuthorizedUser(Person person) {
    	this.authorizedUsers.add(person);
    }

    /**
     * @param person
     * @return true if person matches an authorized user in {@link #authorizedUsers}; otherwise, false.
     */
    public boolean isAuthorizedUser(Person person) {
        return this.authorizedUsers.contains(person);
    }
}
