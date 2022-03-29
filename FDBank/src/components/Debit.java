/**
 * 
 */
package components;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Fabrice
 *
 * 1.3.3 Creation of the Transfert, Credit, Debit classes
 */
public class Debit extends Flow {

	public Debit(@JsonProperty("comments")String comments, @JsonProperty("amount")double amount, @JsonProperty("targetAccountNumber")int targetAccountNumber, @JsonProperty("effect")boolean effect, @JsonProperty("date")LocalDateTime date) {
		super(comments, amount, targetAccountNumber, effect, date);
	}

}
