/**
 * 
 */
package components;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Fabrice
 *
 * 1.3.2 Creation of the Flow class
 */
public abstract class Flow {
	
	private String comments;
	private int identifier;
	private double amount;
	private int targetAccountNumber;
	private boolean effect;
	private LocalDateTime date;
	private static AtomicInteger atomicInteger = new AtomicInteger(0);
	
	public Flow(String comments, double amount, int targetAccountNumber, boolean effect, LocalDateTime date) {
		super();
		this.comments = comments;
		this.amount = amount;
		this.targetAccountNumber = targetAccountNumber;
		this.effect = effect;
		this.date = date;
		this.identifier = atomicInteger.incrementAndGet();
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void setTargetAccountNumber(int targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}

	public void setEffect(boolean effect) {
		this.effect = effect;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
}
