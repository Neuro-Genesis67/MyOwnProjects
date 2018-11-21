package model;

import java.util.ArrayList;

public class Account {
	private String name;
	private String password;
	private ArrayList<Account> accounts = new ArrayList();
	// private ArrayList<filtype> personligeLogsEllerDagb�ger

	public Account(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public Account() {
	}

	public ArrayList<Account> getUsers() {
		return this.accounts;
	}

	public void removeUser(Account user) {
		accounts.remove(user);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addUserToList(Account user) {
		accounts.add(user);
	}

	public String toString() {
		return this.getName();
	}
}
