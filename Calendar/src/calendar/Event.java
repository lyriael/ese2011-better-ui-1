package calendar;

import hirondelle.date4j.DateTime;

public class Event {
	
	private String name;
	private DateTime startTime;
	private DateTime endTime;
	private boolean isPrivate;

	public Event(String name, DateTime startTime, DateTime endTime, boolean isPrivate) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isPrivate = isPrivate;
	}
}
