/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.List;

import components.Client;

/**
 * @author Fabrice
 *
 * 1.1.2 Creation of main class for tests
 */
public class Main {

	static List<Client> Clients;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nbClient = Integer.parseInt("3");
		Clients = loadArray(nbClient);
		displayContent(Clients);
	}

	public static List<Client> loadArray(int nbClient) {
		String name = "name";
		String firstName = "firstname";
		List<Client> result = new ArrayList<>();
		for(int i = 0; i < nbClient; i++) {
			Client c = new Client(name + (i + 1), firstName + (i + 1));
			result.add(c);
		}
		return result;
	}
	
	public static void displayContent(List<Client> listClient) {
		for(Client c : listClient) {
			System.out.println(c.toString());
		}
	}
}
