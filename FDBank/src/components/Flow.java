/**
 * 
 */
package components;

import java.sql.Date;

/**
 * @author Fabrice
 *
 * 1.3.2 Creation of the Flow class
 */
public abstract class Flow {
	
	private String comments;
	private int identifier;
	private float amount;
	private int targetAccountNumber;
	private boolean effect;
	private Date date;
	
	public Flow(String comments, int identifier, float amount, int targetAccountNumber, boolean effect, Date date) {
		super();
		this.comments = comments;
		this.identifier = identifier;
		this.amount = amount;
		this.targetAccountNumber = targetAccountNumber;
		this.effect = effect;
		this.date = date;
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

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
