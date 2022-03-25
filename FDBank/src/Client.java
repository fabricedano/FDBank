import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 */

/**
 * @author Fabrice
 *
 */
//  1.1.1 Creation of the client class
public class Client {

	/**
	 * @param args
	 */
	private static AtomicInteger atomicInteger = new AtomicInteger(0);
	private String name;
	private String firstName;
	private int clientNumber;
	
	public Client(String name, String firstName) {
		this.clientNumber = atomicInteger.incrementAndGet();
		this.name = name;
		this.firstName = firstName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}
	
	public String toString() {
		return this.clientNumber + " " + this.name + " " + this.firstName;
	}
	
	public static void main(String[] args) {
		
	}

}
