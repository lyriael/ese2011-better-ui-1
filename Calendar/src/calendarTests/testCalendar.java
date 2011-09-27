package calendarTests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

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
		Event concert= testCal.addEvent("Crazy evening", "2011-02-18 18:00:00", "2011-02-18 23:00:00");
		Event bdayParty = testCal.addEvent("Bday Party", "2011-02-19 18:00:00", "2011-02-19 20:00:00");
		Event go2bed = testCal.addEvent("Zzz", "2011-02-19 22:00:00", "2011-02-20 23:00:00");
		Event wakeUp = testCal.addEvent("GoodMorning", "2011-02-20 06:00:00", "2011-02-20 07:00:00");
		
	}

	//@Test
	//public void testCalendar() {
	//	System.out.println(testCal.getNextEvent());
	//}
	
	@Test
	public void testShowListOfPrivateDate()
	{
		List<Event> testList =new LinkedList<Event>();
		testList = testCal.getListOfDate("2011-02-19", testCal.getOwner());
			System.out.println(testList.toString());
			assert (testList.size()==2);
	}
	
	@Test
	public void testShowListOfPublicDate()
	{
		User testUser2 = new User("Stöfe");
		List<Event> testList =new LinkedList<Event>();
		testList = testCal.getListOfDate("2011-02-19", testUser2);
		System.out.println(testList.size());
		System.out.println(testList.toString());
		assert (testList.size()==0);
	}
	

	@Test
	public void testIterator() {
		List<Event> testList = new LinkedList<Event>();
	System.out.println( testCal.getAllVisibleEvents(testCal.getOwner(), "2011-02-18"));
		
	}

}
