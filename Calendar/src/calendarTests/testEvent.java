package calendarTests;

import static org.junit.Assert.*;

import java.util.TimeZone;

import hirondelle.date4j.DateTime;

import org.junit.Before;
import org.junit.Test;

import calendar.Event;

public class testEvent {

	private Event eventPast;
	private Event eventToday;

	@Before
	public void setUp() throws Exception {
		eventPast = new Event("TestEvent", "2011-02-19 12:00:00");
		DateTime now = DateTime.now(TimeZone.getDefault());
		eventToday = new Event("Today", now.toString());
	}

	@Test
	public void eventShouldLastOneHour() {
		assertTrue(eventPast.getStartTime().hasHourMinuteSecond());
		assertEquals(3600, eventPast.getStartTime().numSecondsFrom(eventPast.getEndTime()));
	}
	
	@Test
	public void eventShouldBeComparable() {
		assertTrue(eventPast.compareTo(eventToday) < 0);
		assertTrue(eventToday.compareTo(eventPast) > 0);
	}
	
	@Test
	public void shouldBePrivate() {
		assertTrue(eventPast.isPrivate());
		assertTrue(eventToday.isPrivate());
	}

}
