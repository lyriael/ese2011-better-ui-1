package calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Calendar {
	
	private String calendarName;
	ArrayList<Event> eventList= new ArrayList<Event>();
	Scanner scn = new Scanner(System.in);
	
	public Calendar(String calendarName){
		this.calendarName=calendarName;
	}
	
	public void addEvent(){
		
		
		System.out.println("Enter event name:");
		String name = scn.next();
		
		boolean isPrivate = isEventPrivate();
			
			
		Date startTime =new Date();
		Date endTime = new Date();
		Event event = new Event(name, startTime, endTime, isPrivate);
		eventList.add(event);
		
	}

	private boolean isEventPrivate() {
		boolean isPrivate=true;
		System.out.println("Is it private? (Y/N)");
		String tmp = scn.next().toLowerCase();
		if (tmp.contains("y"))
			isPrivate = true;
		else
			isPrivate = false;
		return isPrivate;
	}

}
