package calendarTests;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TimeZone;

import hirondelle.date4j.DateTime;

import org.junit.Before;
import org.junit.Test;

import calendar.Calendar;
import calendar.Event;
import calendar.User;

public class testCalendar {

	private Calendar testCal;
	private Event bdayParty, go2bed, go2Uni, today, somePrivateStuff;
	private User testCalOwner, testUser;

	@Before
	public void setUp() throws Exception {
		testCalOwner = new User("Vofi");
		testUser = new User("Test");
		testCal = new Calendar("Vofi's Cal", testCalOwner);
		bdayParty = testCal.addEvent("Bday Party", "2011-02-19 18:00:00", "2011-02-19 20:00:00", false);
		go2bed = testCal.addEvent("Zzz", "2011-02-19 22:00:00", "2011-02-20 08:00:00", false);
		somePrivateStuff = testCal.addEvent("U don't wanna know", "2011-02-19 22:10:00", "2011-02-19 23:00:00", true);
		go2Uni = testCal.addEvent("Uni", "2011-02-20 09:00:00", "2011-02-20 15:00:00", false);
		DateTime now = DateTime.now(TimeZone.getDefault());
		today = testCal.addEvent("today", now.toString());
	}
	
	@Test
	public void shouldHaveName() {
		assertEquals("Vofi's Cal", testCal.getCalendarName());
	}

	@Test
	public void testGetListOfDate() {
		List<Event> eventList = testCal.getListOfDate("2011-02-19");
		assertTrue(eventList.contains(bdayParty));
		assertTrue(eventList.contains(go2bed));
		assertFalse(eventList.contains(go2Uni));
		assertFalse(eventList.contains(today));
	}
	
	@Test
	public void ownerShouldSeeAllEvents() {
		Iterator<Event> visibleEventsIter = testCal.getVisibleEvents(testCalOwner);
		assertEquals(bdayParty, visibleEventsIter.next());
		assertEquals(go2bed, visibleEventsIter.next());
		assertEquals(somePrivateStuff, visibleEventsIter.next());
		assertEquals(go2Uni, visibleEventsIter.next());
	}
	
	@Test
	public void testUserShouldntSeeAllEvents() {
		Iterator<Event> visibleEventsIter = testCal.getVisibleEvents(testUser);
		assertEquals(bdayParty, visibleEventsIter.next());
		assertEquals(go2bed, visibleEventsIter.next());
		assertEquals(go2Uni, visibleEventsIter.next());
	}

	@Test (expected=NoSuchElementException.class)
	public void shouldHaveNoEventInFuture() {
		testCal.getNextEvent();
	}

}
