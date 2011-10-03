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

    	db = new Database();
        if(db.getUsers().isEmpty()) {
        	User testUser = new User("Johnny");
        	Calendar testCalendar = testUser.createCalendar("Hausaufgaben");;
        	Event event1, event2;
    		event1 = new Event("event1", "17-1-1990 10:00", "17-1-1990 13:00", true);
			event2 = new Event("event2", "17-1-2012 00:00", "18-1-2012 00:00", false);
			testCalendar.addEvent(event1);
			testCalendar.addEvent(event2);
            db.addUser(testUser);
        }

    }
 
}