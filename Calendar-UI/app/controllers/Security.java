package controllers;
 
import models.*;
 
public class Security extends Secure.Security {
	
    static boolean authenticate(String username, String password) {
    	Database db = Database.getInstance();
    	return db.logIn(username, password) != null;
    }
    
}