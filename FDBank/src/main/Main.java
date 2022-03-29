/**
 * 
 */
package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import components.Account;
import components.Client;
import components.Credit;
import components.CurrentAccount;
import components.Debit;
import components.Flow;
import components.SavingsAccount;
import components.Transfer;

/**
 * @author Fabrice
 *
 * 1.1.2 Creation of main class for tests
 */
public class Main {

	static List<Client> clients;
	static List<Account> accounts;
	static Hashtable<Integer, Account> accountTable;
	static List<Flow> flows; 
	
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
		//displayAccountTable(accountTable);
		flows = loadFlow(accounts);
		updateFlow(flows, accountTable);
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
		.sorted((elem1, elem2) -> elem1.getValue().getBalance().compareTo(elem2.getValue().getBalance()))
		.forEach(elem -> System.out.println(elem.toString()));
	}
	
	// 1.3.4 Creation of the flow array
	
	public static List<Flow> loadFlow(List<Account> listAccount) {
		List<Flow> result = new ArrayList<>();
		LocalDateTime date = LocalDateTime.now().plusDays(2);
		Flow debit = new Debit("retrait de 50", 50.0, listAccount.get(0).getAccountNumber(), false, date);
		result.add(debit);
		for(Account a : listAccount) {
			if("Current".equals(a.getLabel())) {
				Flow credit = new Credit("ajout de 100.50", 100.50, a.getAccountNumber(), false, date);
				result.add(credit);
			} else {
				Flow credit = new Credit("ajout de 1500.0", 1500.0, a.getAccountNumber(), false, date);
				result.add(credit);
			}
		}
		Flow transfer = new Transfer("transfer de 50.0",
				50.0,
				listAccount.get(0).getAccountNumber(),
				false,
				date,
				listAccount.get(1).getAccountNumber());
		result.add(transfer);
		return result;
	}
	
	// // 1.3.5 Updating accounts
	public static void updateFlow(List<Flow> listFlow, Hashtable<Integer, Account> listAccountTable) {
		for(Flow f: listFlow) {
			listAccountTable.get(f.getTargetAccountNumber()).setBalance(f);
		}
		Predicate<Account> ngBalance = x -> x.getBalance() < 0;
		listAccountTable.values()
		.stream()
		.filter(ngBalance)
		.forEach(elem -> System.out.println("Balance for" + elem.getAccountNumber() + " is negative" ));
		
		displayAccountTable(listAccountTable);
	}
	
	// 2.1 JSON file of flows
	public static List<Flow> loadJsonFile() {
		Path path = Paths.get("src","flows.json");
		File file = new File(path.toString());
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map;
		try {
			map = mapper.readValue(file, Map.class);
			for(Map.Entry<String, Object> entry : map.entrySet()) {
				if("debit".equals(entry.getKey())) {
					//Flow debit = new Debit(entry.getValue(), 50.0, listAccount.get(0).getAccountNumber(), false, date);
				}
			}
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 2.2 XML file of account
	public static List<Account> loadXmlFile() {
		Path path = Paths.get("src/accounts.xml");
		try {
			Account account = new XmlMapper().readValue(path.toFile().toString(), Account.class);
			String json = new ObjectMapper().writeValueAsString(account);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
