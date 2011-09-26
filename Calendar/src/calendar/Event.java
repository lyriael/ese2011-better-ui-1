package calendar;

import java.util.Iterator;
import java.util.TimeZone;

import hirondelle.date4j.DateTime;
import hirondelle.date4j.DateTime.DayOverflow;

public class Event implements Comparable<Event> {
	
	private String eventName;
	private DateTime startTime;
	private DateTime endTime;
	private boolean isPrivate;

	
	/**
	 * All conversion String <-> DateTime is done here for now
	 * Subject to change! (Maybe implement special class for that)
	 * 
	 * @param EventName
	 * @param startTime
	 * @param endTime
	 * @param isPrivate
	 */
	public Event(String eventName, DateTime startTime, DateTime endTime, boolean isPrivate) {
		fillInData(eventName, startTime, endTime, isPrivate);
	}
	
	public Event(String eventName, String sTime, String eTime) {
		DateTime startTime = new DateTime(sTime);
		DateTime endTime = new DateTime(eTime);
		fillInData(eventName, startTime, endTime, true);
	}
	
	/**
	 * Constructor without ending time. Makes an event with the lenght of one
	 * hour by default. The visibility is private by default.
	 * @param date
	 * @param sTime
	 * @param isPrivate
	 */
	public Event(String eventName, String sTime) {
		//TODO: convert Strings so they're valid
		//for now: organized panic.
		DateTime startTime = new DateTime(sTime);
		DateTime endTime = startTime.plus(0, 0, 0, 1, 0, 0, DayOverflow.Spillover);
		fillInData(eventName, startTime, endTime, true);
	}

	public boolean isPrivate(){
		return isPrivate;
	}
	
	private void fillInData(String eventName, DateTime startTime, DateTime endTime, boolean isPrivate) {
		this.eventName = eventName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isPrivate = isPrivate;
	}
	
	public DateTime getStartTime() {
		return startTime;
	}
	
	public DateTime getEndTime() {
		return endTime;
	}

	@Override
	public int compareTo(Event e) {
		return this.getStartTime().compareTo(e.getStartTime());
	}
	
	public boolean hasSameStartingDateAs(Event e) {
		return e.getStartTime().isSameDayAs(this.getStartTime());
	}

	public boolean startsInPast() {
		return this.getStartTime().isInThePast(TimeZone.getDefault());
	}
	
	public String toString() {
		return eventName + " " + startTime.format("YYYY-MM-DD");
	}
}
