package models;

import hirondelle.date4j.DateTime;
import hirondelle.date4j.DateTime.DayOverflow;

import java.util.TimeZone;

/**
 * For now, the Conversion DateTime <-> String is done here.
 * This is still subject to change!
 * @author panmari
 */
public class Event implements Comparable<Event> {
	
	public String name;
	private DateTime startTime;
	private DateTime endTime;
	private boolean isPrivate;
	private TimeZone currentTZ;
	
	/**
	 * Full constructor
	 * @param eventName
	 * @param sTime
	 * @param eTime
	 * @param isPrivate
	 */
	public Event(String eventName, String sTime, String eTime, boolean isPrivate) {
		DateTime startTime = new DateTime(sTime);
		DateTime endTime = new DateTime(eTime);
		fillInData(eventName, startTime, endTime, isPrivate);
	}
	
	/**
	 * Event is private by default
	 * @param eventName
	 * @param sTime
	 * @param eTime
	 */
	public Event(String eventName, String sTime, String eTime) {
		this(eventName, sTime, eTime, true);
	}
	
	/**
	 * Constructor without ending time. Makes an event with the length of one
	 * hour by default. The visibility is private by default.
	 */
	public Event(String eventName, String sTime, boolean isPrivate) {
		//TODO: convert Strings so they're valid
		//for now: organized panic.
		DateTime startTime = new DateTime(sTime);
		DateTime endTime = startTime.plus(0, 0, 0, 1, 0, 0, DayOverflow.Spillover);
		fillInData(eventName, startTime, endTime, isPrivate);
	}

	public boolean isPrivate(){
		return isPrivate;
	}
	
	private void fillInData(String eventName, DateTime startTime, DateTime endTime, boolean isPrivate) {
		this.name = eventName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isPrivate = isPrivate;
		this.currentTZ = TimeZone.getDefault();
	}
	
	public DateTime getStartTime() {
		return startTime;
	}
	
	public DateTime getEndTime() {
		return endTime;
	}

	/**
	 * => In ordered lists, the earliest Events come first.
	 */
	@Override
	public int compareTo(Event e) {
		return this.getStartTime().compareTo(e.getStartTime());
	}
	
	public boolean hasSameStartingDateAs(Event e) {
		return e.getStartTime().isSameDayAs(this.getStartTime());
	}

	public boolean startsInPast() {
		return this.getStartTime().isInThePast(currentTZ);
	}
	
	public String toString() {
		return name + " " + startTime.format("YYYY-MM-DD");
	}
}
