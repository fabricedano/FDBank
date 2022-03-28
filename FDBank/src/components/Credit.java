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
public class Credit extends Flow {

	public Credit(String comments, double amount, int targetAccountNumber, boolean effect, LocalDateTime date) {
		super(comments, amount, targetAccountNumber, effect, date);
	}

}
