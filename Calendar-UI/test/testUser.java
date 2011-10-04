

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;

import models.Calendar;
import models.User;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;

public class testUser extends UnitTest{

	private User testVofi, testUser;
	Calendar cal1, cal2;

	@Before
	public void setUp() throws Exception {
		testVofi = new User("Vofi", "s3cret");
		testUser = new User("Test", "123");
		cal1 = testUser.createCalendar("123");
		cal2 = testUser.createCalendar("456");
	}

	@Test
	public void testCreateCalendar() {
		Calendar calTest = testVofi.createCalendar("Test Cal");
		assertEquals("Test Cal", calTest.getCalendarName());
	}

	@Test
	public void testGetName() {
		assertEquals("Vofi", testVofi.getName());
		assertEquals("Test", testUser.getName());
	}
	
	@Test
	public void shouldBeIterable() {
		Iterator<Calendar> testIter = testUser.iterator();
		assertEquals(cal1, testIter.next());
		assertEquals(cal2, testIter.next());
		assertFalse(testIter.hasNext());
	}
	
	@Test(expected=RuntimeException.class)
	public void nextEventShouldNotBeImplemented() {
		testUser.getNextEvent();
	}

}
