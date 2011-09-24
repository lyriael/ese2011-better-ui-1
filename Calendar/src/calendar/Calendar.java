package calendar;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Calendar implements Iterable<Event> {
	private String calendarName;
	private PriorityQueue<Event> eventList;
	
	public void Calendar(String calendarName){
		this.calendarName=calendarName;
		eventList = new PriorityQueue<Event>();
	}

	@Override
	public Iterator<Event> iterator() {
		return eventList.iterator();
	}

}
