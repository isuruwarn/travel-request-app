package org.warn.travelrequest.dto;

import java.util.Date;




/**
 * This class encapsulates the data associated with this application 
 * It acts as a DTO to transfer the data between the different layers
 */

public class TravelRequest {
	
	
	private String travelRequestId;
	private String origin;
	private String destination;
	private Date departureDate;
	private String timeOfDeparture;
	private Date arrivalDate;
	private String timeOfArrival;
	private int passengerCount;
	
	
	
	public Date getArrivalDate() {
		return arrivalDate;
	}
	
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	
	public Date getDepartureDate() {
		return departureDate;
	}
	
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
		
	
	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	
	public String getTimeOfArrival() {
		return timeOfArrival;
	}
	
	public void setTimeOfArrival(String timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}
	
	
	public String getTimeOfDeparture() {
		return timeOfDeparture;
	}
	
	public void setTimeOfDeparture(String timeOfDeparture) {
		this.timeOfDeparture = timeOfDeparture;
	}
	
	
	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	
	
	public String getTravelRequestId() {
		return travelRequestId;
	}

	public void setTravelRequestId(String travelRequestId) {
		this.travelRequestId = travelRequestId;
	}
	
	
}
