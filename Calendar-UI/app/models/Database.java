package models;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Now with singleton pattern!
 * @author panmari
 */
public class Database {
	private List<User> userList;
	private static Database db;
	
	/**
	 * Initializes a new userList
	 */
	private Database() {
		userList = new LinkedList<User>();
	}	
	
	public static Database getInstance() {
		if (db == null)
			db = new Database();
		return db;
	}
	
	/**
	 * @param initialUsers  a List of already existing users
	 */
	public Database(LinkedList<User> initialUsers) {
		this.userList = initialUsers;
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
	
	public List<User> getUsers() {
		return userList;
	}
	
	public User getUserByName(String name) {
		for (User u: userList) {
			if (u.getName().equals(name))
				return u;
		}
		throw new NoSuchElementException("No User with that name!");
	}
}
