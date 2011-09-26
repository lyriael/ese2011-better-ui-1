package calendar;

import hirondelle.date4j.DateTime;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TimeZone;

public class User implements Iterable<Calendar> {
	private String name;
	private List<Calendar> calendars;
	
	public User (String name){
		this.name = name;
		this.calendars = new LinkedList<Calendar>();
	}
	
	public void createCalendar(String name) {
		Calendar newCal = new Calendar(name, this);
		calendars.add(newCal);
	}
	
	public String getName(){
		return name;
	}
	
	private Event getNextEvent() {
		//TODO: 
		/*
			Event nextEvent = 
		for (Calendar c: this) {
			Event nextEvent = c.getNextEvent();
		}
		throw new NoSuchElementException();
		*/
		return null;
	}

	@Override
	public Iterator<Calendar> iterator() {
		return calendars.iterator();
	}
	
	
}
