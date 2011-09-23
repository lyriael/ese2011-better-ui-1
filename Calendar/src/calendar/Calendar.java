package calendar;

import java.util.PriorityQueue;

public class Calendar {
	private String calendarName;
	private PriorityQueue<Event> eventList;
	
	public void Calendar(String calendarName){
		this.calendarName=calendarName;
		eventList = new PriorityQueue<Event>();
	}

}
