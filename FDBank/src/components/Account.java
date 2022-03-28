/**
 * 
 */
package components;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Fabrice
 *
 * 1.2.1 Creation of the account class
 */
public abstract class Account {

	protected String label;
	protected Flow balance;
	protected int accountNumber;
	protected Client client;
	private static AtomicInteger atomicInteger = new AtomicInteger(0);
	
	public Account(String label, Client client) {
		super();
		this.label = label;
		this.client = client;
		this.accountNumber = atomicInteger.incrementAndGet();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Flow getBalance() {
		return balance;
	}

	public void setBalance(Flow balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Account [label=" + label + ", balance=" + balance + ", accountNumber=" + accountNumber + ", client="
				+ client + "]";
	}

}
