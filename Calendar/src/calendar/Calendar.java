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
		List<Event> publicEvents = new LinkedList<Event>();
		List<Event> privateEvents= new LinkedList<Event>();
		Event dummyEvent = new Event("dummy", startDate);
		if (user == owner){
			for (Event e: this){
				if (e.compareTo(dummyEvent)>0)
					privateEvents.add(e);
			}
			return privateEvents.iterator();
		}
		else {
			for(Event e: this) {
				if (!e.isPrivate() && e.compareTo(dummyEvent)>0)
					publicEvents.add(e);
			}
			return publicEvents.iterator();
		}
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
		User tempUser= new User(null);
		tempUser = user;
		if (user==owner){
			return getPrivateListofDate(ListOfSpecificDate, dummyEvent);
		}
		else{
			return getPublicListofDate(ListOfSpecificDate, dummyEvent);
		}
				
	}

	private List<Event> getPublicListofDate(List<Event> ListOfSpecificDate,
			Event dummyEvent) {
		for (Event e: this) {
			if (e.hasSameStartingDateAs(dummyEvent) && e.isPrivate()==false)
				ListOfSpecificDate.add(e);
		}
		return ListOfSpecificDate;
	}

	private List<Event> getPrivateListofDate(List<Event> ListOfSpecificDate,
			Event dummyEvent) {
		for (Event e: this) {
			if (e.hasSameStartingDateAs(dummyEvent))
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
