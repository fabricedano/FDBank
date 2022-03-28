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
public class Debit extends Flow {

	public Debit(String comments, double amount, int targetAccountNumber, boolean effect, LocalDateTime date) {
		super(comments, amount, targetAccountNumber, effect, date);
	}

}
