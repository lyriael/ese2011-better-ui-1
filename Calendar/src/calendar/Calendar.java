package calendar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Calendar implements Iterable<Event> {
	private String calendarName;
	private User owner;
	private PriorityQueue<Event> eventList;
	
	public Calendar(String calendarName, User owner){
		this.setCalendarName(calendarName);
		this.owner = owner;
		eventList = new PriorityQueue<Event>();
	}

	@Override
	public Iterator<Event> iterator() {
		return eventList.iterator();
	}
	
	/**
	 * TODO: Starting Date as Parameter.
	 * @param user
	 * @return
	 */
	
	
	public Iterator<Event> getAllVisibleEventsAfter(User user, String startDate) {
		List<Event> returnedEvents = new LinkedList<Event>();
		Event dummyEvent = new Event("dummy", startDate);
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
	
	public List<Event> getListOfDate(String Date, User user) {
		List<Event> ListOfSpecificDate = new LinkedList<Event>();
		Event dummyEvent = new Event("dummy", Date);
		boolean isOwner = false;
		if (user == owner) 
			isOwner = true;
		for (Event e: this) {
			if (e.hasSameStartingDateAs(dummyEvent) && 
					((e.isPrivate() && isOwner) || !e.isPrivate()))
				ListOfSpecificDate.add(e);
		}
		return ListOfSpecificDate;	
	}
	
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
	

	public Event addEvent(String eventName, String sTime, String eTime) {
		return this.addEvent(eventName, sTime, eTime, true);
	}

	public Event addEvent(String eventName, String date) {
		Event newEvent = new Event(eventName, date);
		eventList.add(newEvent);
		return newEvent;
	}
	
	public Event addEvent(String eventName, String sTime, String eTime, boolean isPrivate) {
		Event newEvent = new Event(eventName, sTime, eTime, isPrivate);
		eventList.add(newEvent);
		return newEvent;
	}

}
