/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
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

	static List<Client> clients;
	static List<Account> accounts;
	static Hashtable<Integer, Account> accountTable;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nbClient = Integer.parseInt("3");
		clients = loadClients(nbClient);
		displayClients(clients);
		accounts = loadAccounts(clients);
		displayAccounts(accounts);
		accountTable = loadHashtable(accounts);
		displayAccountTable(accountTable);
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
	
	// 1.3.1 Adaptation of the table of accounts
	
	public static Hashtable<Integer, Account> loadHashtable(List<Account> listAccount) {
		accountTable = new Hashtable<Integer, Account>();
		for(Account a : listAccount) {
			accountTable.put(a.getAccountNumber(), a);
		}
		return accountTable;
	}
	
	public static void displayAccountTable(Hashtable<Integer, Account> listAccountTable) {
		listAccountTable.entrySet()
		.stream()
		.sorted((elem1, elem2) -> -elem1.getValue().getBalance().compareTo(elem2.getValue().getBalance()))
		.forEach(elem -> System.out.println(elem.toString()));
	}
}
