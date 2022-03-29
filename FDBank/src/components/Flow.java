/**
 * 
 */
package components;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
	
	public Flow(@JsonProperty("comments")String comments, @JsonProperty("amount")double amount, @JsonProperty("targetAccountNumber")int targetAccountNumber, @JsonProperty("effect")boolean effect, @JsonProperty("date")LocalDateTime date) {
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

	public String getComments() {
		return comments;
	}

	public int getIdentifier() {
		return identifier;
	}

	public double getAmount() {
		return amount;
	}

	public int getTargetAccountNumber() {
		return targetAccountNumber;
	}

	public boolean isEffect() {
		return effect;
	}

	public LocalDateTime getDate() {
		return date;
	}
	
}
