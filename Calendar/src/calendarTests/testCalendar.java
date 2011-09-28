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
	private Event XmasLastYear;

	@Before
	public void setUp() throws Exception {
		testCalOwner = new User("TestOwner");
		testUser = new User("Test");
		testCal = new Calendar("TestOwner's Cal", testCalOwner);
		DateTime now = DateTime.now(TimeZone.getDefault());
		today = testCal.addEvent("today", now.toString());
		XmasLastYear =  testCal.addEvent("Xmas", "2010-12-25 18:00:00", "2010-12-25 20:00:00", false);
		bdayParty = testCal.addEvent("Bday Party", "2011-02-19 18:00:00", "2011-02-19 20:00:00", false);
		go2bed = testCal.addEvent("Zzz", "2011-02-19 22:00:00", "2011-02-20 08:00:00", false);
		somePrivateStuff = testCal.addEvent("U don't wanna know", "2011-02-19 22:10:00", "2011-02-19 23:00:00", true);
		go2Uni = testCal.addEvent("Uni", "2011-02-20 09:00:00", "2011-02-20 15:00:00", false);
	}
	
	@Test
	public void shouldHaveNameAndOwner() {
		assertEquals(testCalOwner, testCal.getOwner());
		assertEquals("TestOwner's Cal", testCal.getCalendarName());
	}
	

	@Test
	public void testStandardIterator() {
		Iterator<Event> allEvents = testCal.iterator();
		assertEquals(XmasLastYear, allEvents.next());
		assertEquals(bdayParty, allEvents.next());
		assertEquals(go2bed, allEvents.next());
		assertEquals(somePrivateStuff, allEvents.next());
		assertEquals(go2Uni, allEvents.next());
		assertEquals(today, allEvents.next());
	}
	@Test
	public void testGetListOfDate() {
		List<Event> eventList = testCal.getListOfSpecificDate("2011-02-19", testCalOwner);
		assertTrue(eventList.contains(bdayParty));
		assertTrue(eventList.contains(go2bed));
		assertTrue(eventList.contains(somePrivateStuff));
		assertFalse(eventList.contains(go2Uni));
		assertFalse(eventList.contains(today));
	}
	
	@Test
	public void testGetAllVisibleEvents() {
		List<Event> eventList = testCal.getListOfSpecificDate("2011-02-19", testUser);
		assertTrue(eventList.contains(bdayParty));
		assertTrue(eventList.contains(go2bed));
		assertFalse(eventList.contains(somePrivateStuff));
		assertFalse(eventList.contains(go2Uni));
		assertFalse(eventList.contains(today));
	}
	
	@Test
	public void ownerShouldSeeAllEvents() {
		Iterator<Event> visibleEventsIter = testCal.getAllVisibleEventsAfter(testCalOwner, "2011-02-19");
		assertEquals(bdayParty, visibleEventsIter.next());
		assertEquals(go2bed, visibleEventsIter.next());
		assertEquals(somePrivateStuff, visibleEventsIter.next());
		assertEquals(go2Uni, visibleEventsIter.next());
		assertEquals(today, visibleEventsIter.next());
	}
	
	@Test
	public void testUserShouldntSeeAllEvents() {
		Iterator<Event> visibleEventsIter = testCal.getAllVisibleEventsAfter(testUser, "2011-02-19");
		assertEquals(bdayParty, visibleEventsIter.next());
		assertEquals(go2bed, visibleEventsIter.next());
		assertEquals(go2Uni, visibleEventsIter.next());
	}

	@Test (expected=NoSuchElementException.class)
	public void shouldHaveNoEventInFuture() {
		testCal.getNextEvent();
	}
	
	@Test
	public void shouldHaveNextEvent() {
		Event futureEvent = testCal.addEvent("Event in future", "2020-12-10");
		assertEquals(futureEvent, testCal.getNextEvent());
	}

}
