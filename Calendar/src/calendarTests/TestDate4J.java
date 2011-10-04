package calendarTests;

import hirondelle.date4j.*;

import org.junit.Test;

public class TestDate4J {

	@Test(expected=RuntimeException.class)
	public void test() {
		DateTime test = new DateTime("blub");
		test.getYear();
	}

}
