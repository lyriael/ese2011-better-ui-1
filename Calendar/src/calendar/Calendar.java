package calendar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
	public Iterator<Event> getVisibleEvents(User user) {
		List<Event> publicEvents = new LinkedList<Event>();
		if (user == owner)
			return iterator();
		else {
			for(Event e: this) {
				if (!e.isPrivate())
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
	
	public List<Event> getListOfDate(String Date) {
		List<Event> ListOfDate = new LinkedList<Event>();
		//TODO: Stuff to do
		blub = new DateTime(Date);
		for (Event e: this) {
			e.getStartTime().isSameDayAs(arg0)
		}
		return ;
		
	}

}
