package org.warn.travelrequest.model;


import java.util.*;
import java.text.DateFormatSymbols;



/** 
 * This class is one of the Model classes in the MVC
 * It contains the logic behind the values for the combo boxes 
 */


public class TravelFormLogic {
	
	
	public ArrayList<Integer> getDateValues() {
		
		ArrayList<Integer> dateValues = new ArrayList<Integer>();
		int maxDays = 31;
		
		for(int i=1; i<=maxDays; i++) {
			dateValues.add(i); //wrapping not necessary due to autoboxing in J2SE 1.5 and above
		}
		
		return dateValues;
	}
	
	
	
	public ArrayList<String> getMonthValues() {
		
		ArrayList<String> monthValues = new ArrayList<String>();
		String[] months = new DateFormatSymbols().getMonths(); //get names of all months
		
		for(int i=0; i<months.length; i++) {
			if(!"".equals(months[i])) {
				monthValues.add(months[i]);
			}
		}
		
		return monthValues;
	}
	
	
	
	public ArrayList<Integer> getYearValues() {
		
		ArrayList<Integer> yearValues = new ArrayList<Integer>();
		
		// Values 2007 and 2008 are used here since they are specified in the requirements.
		yearValues.add(2007);
		yearValues.add(2008); 
		
		
		//Alternatively these values could also be set dynamically, based on the current year, as shown below
		/*
		int year = Calendar.getInstance().get(Calendar.YEAR); //get current year
		for(int i=0; i<5; i++) {
			yearValues.add(year+i);
		}
		*/
		
		return yearValues;
	}
	
	
	
	public ArrayList<String> getTimeValues() {
		
		ArrayList<String> timeValues = new ArrayList<String>();
		
		//Ideally these should be stored and retrieved from a database table
		timeValues.add("anytime");
		timeValues.add("morning");
		timeValues.add("noon");
		timeValues.add("evening");
		timeValues.add("late night");
		
		return timeValues;
	}
	
	
	
	public ArrayList<Integer> getPassengerValues() {
		
		ArrayList<Integer> passengerCount = new ArrayList<Integer>();
		
		//Ideally this value should be stored and retrieved from a property file or database table
		int maxNoOfPassengers = 10;
		
		for(int i=1; i<=maxNoOfPassengers; i++) {
			passengerCount.add(i);
		}
		
		return passengerCount;
	}
	
	
}
