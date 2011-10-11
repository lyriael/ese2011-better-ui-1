package models;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Calendar implements Iterable<Event> {
	private String calendarName;
	private User owner;
	private List<Event> eventList;
	
	public Calendar(String calendarName, User owner){
		this.setCalendarName(calendarName);
		this.owner = owner;
		eventList = new LinkedList<Event>();
	}

	/**
	 * This iterator is in order from the earliest Event to the latest.
	 */
	@Override
	public Iterator<Event> iterator() {
		Collections.sort(eventList);
		return eventList.iterator();
	}
	
	/**
	 * Shows all visible events (since 1900-01-01, which should
	 * be enough)
	 * @param user
	 */
	public Iterator<Event> getAllVisibleEvents(User user) {
		return getAllVisibleEventsAfter(user, "1900-01-01");
	}
	
	public Iterator<Event> getAllVisibleEventsAfter(User user, String startDate) {
		List<Event> returnedEvents = new LinkedList<Event>();
		Event dummyEvent = new Event("dummy", startDate, true);
		if (user == owner){
			for (Event e: this){
				if (e.compareTo(dummyEvent)>0)
					returnedEvents.add(e);
			}
		} else {
			for(Event e: this) {
				if (!e.isPrivate() && e.compareTo(dummyEvent)>0)
					returnedEvents.add(e);
			}
		}
		return returnedEvents.iterator();
	}
	public String getCalendarName() {
		return calendarName;
	}

	private void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}
	
	public List<Event> getListOfSpecificDate(String Date, User user) {
		List<Event> ListOfSpecificDate = new LinkedList<Event>();
		Event dummyEvent = new Event("dummy", Date, true);
		for (Event e: this) {
			if (e.hasSameStartingDateAs(dummyEvent) && 
					isEventVisibleFor(e, user))
				ListOfSpecificDate.add(e);
		}
		return ListOfSpecificDate;	
	}
	
	/**
	 * not used right now..
	 * @return
	 */
	public Event getNextEvent() {
		for (Event e: this) {
			if (!e.startsInPast())
				return e;
		}
		throw new NoSuchElementException("No future event!");
	}
	
	public User getOwner(){
		return owner;
		}
	
	public String getName() {
		return calendarName;
	}
	
	private boolean isEventVisibleFor(Event e, User user) {
		return (e.isPrivate() && owner == user) || !e.isPrivate();
	}

	public Event addEvent(Event e) {
		eventList.add(e);
		return e;
	}
	public Event addEvent(String eventName, String sTime, String eTime) {
		return this.addEvent(eventName, sTime, eTime, true);
	}
	
	public Event addEvent(String eventName, String sTime, String eTime, boolean isPrivate) {
		if (eventName.isEmpty() || sTime.isEmpty())
			throw new RuntimeException("Please insert at least a start time and description");
		Event newEvent;
		if (eTime.isEmpty())
			newEvent = new Event(eventName, sTime, isPrivate);
		else newEvent = new Event(eventName, sTime, eTime, isPrivate);
		eventList.add(newEvent);
		return newEvent;
	}

	public Event getEventByName(String eventName) {
		for (Event e: this) 
			if (e.name.equals(eventName))
				return e;
		
		throw new NoSuchElementException("No Event with that name!");
		}

	public boolean removeEvent(Event e) {
		return eventList.remove(e);
	}
	}

