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
	private Event eventPastPublic;
	private Event eventPast2;

	@Before
	public void setUp() throws Exception {
		eventPast = new Event("TestEvent", "2011-02-19 12:00:00");
		eventPast2 = new Event("TestEvent", "2011-02-18 12:00:00");
		eventPastPublic = new Event("TestEvent2", "2011-02-19 14:00:00", "2011-02-19 16:00:00",  false);
		DateTime now = DateTime.now(TimeZone.getDefault());
		eventToday = new Event("Today", now.toString());
	}

	@Test
	public void eventShouldLastOneHour() {
		assertTrue(eventPast.getStartTime().hasHourMinuteSecond());
		assertEquals(3600, eventPast.getStartTime().numSecondsFrom(eventPast.getEndTime()));
	}
	
	@Test
	public void shouldGetStartTime() {
		DateTime testE = eventPast.getStartTime();
		assertEquals(new Integer(2011), testE.getYear());
		assertEquals(new Integer(02), testE.getMonth());
		assertEquals(new Integer(19), testE.getDay());
		assertEquals(new Integer(12), testE.getHour());
		assertEquals(new Integer(00), testE.getMinute());
		assertEquals(new Integer(00), testE.getSecond());
	}
	
	@Test
	public void shouldStartInPast() {
		assertTrue(eventPast.startsInPast());
		assertTrue(eventPastPublic.startsInPast());
	}
	
	@Test
	public void eventShouldBeComparable() {
		assertTrue(eventPast2.compareTo(eventPast) < 0);
		assertTrue(eventPast.compareTo(eventToday) < 0);
		assertTrue(eventToday.compareTo(eventPast) > 0);
	}
	
	@Test
	public void shouldHaveSameStartingDate() {
		assertTrue(eventPastPublic.hasSameStartingDateAs(eventPast));
	}
	
	@Test
	public void shouldBePrivate() {
		assertTrue(eventPast.isPrivate());
		assertTrue(eventToday.isPrivate());
	}
	
	@Test
	public void shouldBePublic() {
		assertFalse(eventPastPublic.isPrivate());
	}
	
	@Test
	public void testToString() {
		assertEquals("TestEvent" + " " + "2011-02-19", eventPast.toString());
	}
}
