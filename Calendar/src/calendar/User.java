package calendar;

import hirondelle.date4j.DateTime;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.TimeZone;

public class User {
	private String name;
	private PriorityQueue<Event> eventList;
	
	public User (String name){
		this.name = name;
		eventList = new PriorityQueue<Event>();
	}
	
	public String getName(){
		return name;
	}
	
	public Event addEvent(String eventName, String date, String time) {
		Event newEvent = new Event(eventName, date, time);
		return newEvent;
	}
	
	private Event getNextEvent() {
		for (Event e: eventList) {
			DateTime startTime = e.getStartTime();
			if (startTime.isInTheFuture(TimeZone.getDefault()))
				return e;
		}
		throw new NoSuchElementException();
	}
	
	
}
