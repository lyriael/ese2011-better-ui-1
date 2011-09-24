package calendar;

import java.util.ArrayList;
import java.util.Scanner;


public class CalendarMain {
	
	ArrayList<User> userList = new ArrayList<User>();
	Scanner scn = new Scanner(System.in);	
	
	public void addUser(){
		System.out.println("Enter username:");
		String tempName = scn.next();
		User user = new User(tempName);
		userList.add(user);
		System.out.println(tempName);
	}

}
