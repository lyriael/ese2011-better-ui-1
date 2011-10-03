package models;

import java.util.LinkedList;
import java.util.List;

public class Database {
	private List<User> userList;
	
	/**
	 * Initializes a new userList
	 */
	public Database() {
		userList = new LinkedList<User>();
	}	
	
	/**
	 * @param initialUsers  a List of already existing users
	 */
	public Database(LinkedList<User> initialUsers) {
		this.userList = initialUsers;
	}
	
	public void addUser(User toAddUser) {
		userList.add(toAddUser);
	}
	
	public List<User> getUsers() {
		return userList;
	}
}
