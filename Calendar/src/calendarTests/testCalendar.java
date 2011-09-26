package calendarTests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.TimeZone;

import hirondelle.date4j.DateTime;

import org.junit.Before;
import org.junit.Test;

import calendar.Calendar;
import calendar.Event;
import calendar.User;

public class testCalendar {

	private Calendar testCal;
	private Event bdayParty;
	private Event go2bed;
	private Event go2Uni;
	private Event today;

	@Before
	public void setUp() throws Exception {
		User testUser = new User("Vofi");
		testCal = new Calendar("Vofi's Cal", testUser);
		bdayParty = testCal.addEvent("Bday Party", "2011-02-19 18:00:00", "2011-02-19 20:00:00");
		go2bed = testCal.addEvent("Zzz", "2011-02-19 22:00:00", "2011-02-20 08:00:00");
		go2Uni = testCal.addEvent("Uni", "2011-02-20 09:00:00", "2011-02-20 15:00:00");
		DateTime now = DateTime.now(TimeZone.getDefault());
		today = testCal.addEvent("today", now.toString());
	}

	@Test
	public void testGetListOfDate() {
		List<Event> eventList = testCal.getListOfDate("2011-02-19");
		assertTrue(eventList.contains(bdayParty));
		assertTrue(eventList.contains(go2bed));
		assertFalse(eventList.contains(go2Uni));
	}

	@Test
	public void testPriorityQueue() {
		fail("Not yet implemented");
	}

}
