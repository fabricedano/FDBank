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
public class Credit extends Flow {

	public Credit(String comments, int identifier, float amount, int targetAccountNumber, boolean effect, Date date) {
		super(comments, identifier, amount, targetAccountNumber, effect, date);
	}

}