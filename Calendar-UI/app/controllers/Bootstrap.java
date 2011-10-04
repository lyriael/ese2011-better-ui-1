package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import play.*;
import play.jobs.*;
import play.test.*;
 
import models.*;
 
@OnApplicationStart
public class Bootstrap extends Job {
 
	public Database db;
	
    public void doJob() {

    	db = Database.getInstance();
        if(db.getUsers().isEmpty()) {
        	User testUser = new User("Johnny", "J");
        	User testUser2 = new User("Jack", "Ja");
        	Calendar testCalendar = testUser.createCalendar("Hausaufgaben");
        	Calendar testCal2 = testUser.createCalendar("Stuff");
        	Event event1, event2;
    		event1 = new Event("event1", "1990-01-17 10:00", "1990-01-17 13:00", true);
			event2 = new Event("event2", "2012-01-17 00:00", "2012-01-18 00:00", false);
			testCalendar.addEvent(event1);
			testCalendar.addEvent(event2);
            db.addUser(testUser);
            db.addUser(testUser2);
        }

    }
 
}