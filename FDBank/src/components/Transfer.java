/**
 * 
 */
package components;

import java.sql.Date;

/**
 * @author Fabrice
 *
 * 1.3.3 Creation of the Transfert, Credit, Debit classes
 */
public class Transfer extends Flow{
	
	private int accountNumber;

	public Transfer(String comments, int identifier, float amount, int targetAccountNumber, boolean effect, Date date, int accountNumber) {
		super(comments, identifier, amount, targetAccountNumber, effect, date);
		this.accountNumber = accountNumber;
	}

}
