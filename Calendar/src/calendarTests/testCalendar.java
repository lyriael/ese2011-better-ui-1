package calendarTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calendar.Calendar;
import calendar.Event;
import calendar.User;

public class testCalendar {

	private Calendar testCal;

	@Before
	public void setUp() throws Exception {
		User testUser = new User("Vofi");
		testCal = new Calendar("Vofi's Cal", testUser);
		Event bdayParty = testCal.addEvent("Bday Party", "2011-02-19 18:00:00", "2011-02-19 20:00:00");
		Event go2bed = testCal.addEvent("Zzz", "2011-02-19 22:00:00", "2011-02-20 08:00:00");
		
	}

	@Test
	public void testCalendar() {
		System.out.println(testCal.getNextEvent());
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

}
