package components;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 */

/**
 * @author Fabrice
 *
 * 1.1.1 Creation of the client class
 */
public class Client {
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

	@Override
	public String toString() {
		return "Client [name=" + name + ", firstName=" + firstName + ", clientNumber=" + clientNumber + "]";
	}

}
