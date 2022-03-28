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
	protected Double balance = 0.0;
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

	public Double getBalance() {
		return balance;
	}
	
	// 1.3.5 Updating accounts
	public void setBalance(Flow balance) {
		if(balance instanceof Debit) {
			this.balance -= balance.getAmount();
		} else if(balance instanceof Credit) {
			this.balance += balance.getAmount();
		} else {
			if(balance.getTargetAccountNumber() == this.accountNumber) {
				this.balance += balance.getAmount();
			} else {
				this.balance -= balance.getAmount();
			}
		}
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
