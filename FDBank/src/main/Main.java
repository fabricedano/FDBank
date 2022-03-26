/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import components.Account;
import components.Client;
import components.CurrentAccount;
import components.SavingsAccount;

/**
 * @author Fabrice
 *
 * 1.1.2 Creation of main class for tests
 */
public class Main {

	static List<Client> Clients;
	static List<Account> Accounts;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nbClient = Integer.parseInt("3");
		Clients = loadClients(nbClient);
		displayClients(Clients);
		Accounts = loadAccounts(Clients);
		displayAccounts(Accounts);
	}

	public static List<Client> loadClients(int nbClient) {
		String name = "name";
		String firstName = "firstname";
		List<Client> result = new ArrayList<>();
		for(int i = 0; i < nbClient; i++) {
			Client c = new Client(name + (i + 1), firstName + (i + 1));
			result.add(c);
		}
		return result;
	}
	
	public static void displayClients(List<Client> listClient) {
		for(Client c : listClient) {
			System.out.println(c.toString());
		}
	}
	
	// 1.2.3 Creation of the table account
	
	public static List<Account> loadAccounts(List<Client> listClient) {
		List<Account> result = new ArrayList<>();
		for(Client c : listClient) {
			CurrentAccount ca = new CurrentAccount("Current", c);
			SavingsAccount sa = new SavingsAccount("Savings", c);
			Collections.addAll(result, ca, sa);
		}
		return result;
	}
	
	public static void displayAccounts(List<Account> listAccount) {
		for(Account a : listAccount) {
			System.out.println(a.toString());
		}
	}
}
