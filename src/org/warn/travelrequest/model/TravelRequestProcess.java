package org.warn.travelrequest.model;


import java.util.*;

import org.warn.travelrequest.dto.TravelRequest;

import java.text.SimpleDateFormat;



/** 
 * This class is one of the Model classes in the MVC
 * It processes the data entered by the user
 */

public class TravelRequestProcess {
	
	
	
	public boolean saveTravelRequestDetails( TravelRequest travelRequest ) {
		
		boolean savedSuccessfully = false;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		
		try {
			String origin = travelRequest.getOrigin();
			String destination = travelRequest.getDestination();
			Date departureDate = travelRequest.getDepartureDate();
			String timeOfDeparture = travelRequest.getTimeOfDeparture();
			Date arrivalDate = travelRequest.getArrivalDate();
			String timeOfArrival = travelRequest.getTimeOfArrival();
			int passengerCount = travelRequest.getPassengerCount();
			
			
			System.out.println("Travel Request Details - " + origin + " | " + destination + " | " 
					+ sdf.format(departureDate) + " " + timeOfDeparture + " | " 
					+ sdf.format(arrivalDate) + " " + timeOfArrival + " | " 
					+ passengerCount 
					);
			
			
			//Generate new TravelRequestId (to be used as primary key)
			//This part has not been implemented since it is not part of the requirement
			
			
			//Save details into a persistant data store such as a database
			//This part has not been implemented since it is not part of the requirement
			
			
			//Return true if details are saved without any errors
			savedSuccessfully = true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return savedSuccessfully;
	}
	
	
	
	
	//This part has not been implemented since it is not part of the requirement
	public TravelRequest viewTravelRequestDetails( String travelRequestId ) {
		
		TravelRequest travelRequest = new TravelRequest();
		
		//Retrieve correct TravelRequest from persistant data store based on travelRequestId
		
		return travelRequest;
	}
	
	
	
	
	//This part has not been implemented since it is not part of the requirement
	public String deleteTravelRequestDetails( String travelRequestId ) {
		
		String deleteStatus = "";
		
		//Delete correct TravelRequest from persistant data store based on travelRequestId
		
		return deleteStatus;
	}
	
	
	
	
}