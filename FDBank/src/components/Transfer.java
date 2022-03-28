/**
 * 
 */
package components;

import java.time.LocalDateTime;

/**
 * @author Fabrice
 *
 * 1.3.3 Creation of the Transfert, Credit, Debit classes
 */
public class Transfer extends Flow {
	
	private int accountNumber;

	public Transfer(String comments, double amount, int targetAccountNumber, boolean effect, LocalDateTime date, int accountNumber) {
		super(comments, amount, targetAccountNumber, effect, date);
		this.accountNumber = accountNumber;
	}
	
	

}
