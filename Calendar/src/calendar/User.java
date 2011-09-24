package calendar;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	private String name;
	Scanner scn =new Scanner(System.in);
	ArrayList<Calendar> calendarList= new ArrayList<Calendar>();
	
	public User (String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void addCalendar(){
		System.out.println("Enter calendar name:");
		String tempName = scn.next();
		Calendar calendar = new Calendar(tempName);
		calendarList.add(calendar);
		
	}
}
