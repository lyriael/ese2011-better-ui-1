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
	
	public Calendar createCalendar(String name) {
		Calendar newCal = new Calendar(name, this);
		calendars.add(newCal);
		return newCal;
	}
	
	public String getName(){
		return name;
	}
	
	public Event getNextEvent() {
		throw new RuntimeException("Not implemented yet!");
	}

	@Override
	public Iterator<Calendar> iterator() {
		return calendars.iterator();
	}
	
	
}
