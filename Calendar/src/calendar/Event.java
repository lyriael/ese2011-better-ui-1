package calendar;

import java.util.Date;

public class Event {
	
	private String name;
	private Date startTime;
	private Date endTime;
	private boolean isPrivate;

	public Event(String name, Date startTime, Date endTime, boolean isPrivate) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isPrivate = isPrivate;
	}
	
	public boolean isPrivate(){
		return isPrivate;
	}
}
