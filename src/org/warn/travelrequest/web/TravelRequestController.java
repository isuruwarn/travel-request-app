package org.warn.travelrequest.web;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.warn.travelrequest.dto.TravelRequest;
import org.warn.travelrequest.model.TravelFormLogic;
import org.warn.travelrequest.model.TravelRequestProcess;




/** 
 * This Servlet class would act as the Controller (of the MVC) for this application 
 */

public class TravelRequestController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	TravelFormLogic travelFormLogic = new TravelFormLogic();
	
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		
		
		try {
			String mode = req.getParameter("mode");
			
			if(mode!=null && mode.equals("load")) {
				loadTravelForm(req, res);
			}
			
			else if(mode!=null && mode.equals("submit")) {
				saveTravelRequestDetails(req, res);
			}
			
			/*
			//This part has not been implemented since it is not part of the requirement
			
			else if(mode!=null && mode.equals("view")) {
				
			}
			
			else if(mode!=null && mode.equals("delete")) {
				
			}
			*/
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void loadTravelForm(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			loadDateValues( req, res );
			loadMonthValues( req, res );
			loadYearValues( req, res );
			loadTimeValues( req, res );
			loadPassengerValues( req, res );

			RequestDispatcher view = req.getRequestDispatcher("TravelRequestApp.jsp");
			view.forward(req, res);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void saveTravelRequestDetails(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			TravelRequestProcess process = new TravelRequestProcess();
			TravelRequest travelRequest = new TravelRequest();
			
			
			//Retrieve submitted form data from the Presentation Layer  
			String origin = req.getParameter("txtOrigin");
			String destination = req.getParameter("txtDestination");
			String departureMM = req.getParameter("departureMM");
			String departureDD = req.getParameter("departureDD");
			String departureYY = req.getParameter("departureYY");
			String timeOfDeparture = req.getParameter("departureTime");
			String returnMM = req.getParameter("returnMM");
			String returnDD = req.getParameter("returnDD");
			String returnYY = req.getParameter("returnYY");
			String timeOfArrival = req.getParameter("returnTime");
			int passengerCount = Integer.parseInt( req.getParameter("passengerCount") );
			
			
			//Create Date objects for Departure Date and Arrival Date
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
			Date departureDate = sdf.parse( departureDD + departureMM + departureYY );
			Date arrivalDate = sdf.parse( returnDD + returnMM + returnYY );
			
			
			//Set Data Transfer Object with the new Travel Request data
			travelRequest.setOrigin(origin);
			travelRequest.setDestination(destination);
			travelRequest.setDepartureDate(departureDate);
			travelRequest.setTimeOfDeparture(timeOfDeparture);
			travelRequest.setArrivalDate(arrivalDate);
			travelRequest.setTimeOfArrival(timeOfArrival);
			travelRequest.setPassengerCount(passengerCount);
			
			
			//Send the data using the DTO to the Model class, to be saved
			boolean savedSuccessfully = process.saveTravelRequestDetails(travelRequest);
			
			
			//Give a feedback to the user on whether the details were saved successfully
			if(savedSuccessfully) {
				req.setAttribute("StatusMsg", "Your Travel Request has been processed successfully...");
			}
			else {
				req.setAttribute("StatusMsg", "Error while processing Travel Request details! Please try again.");
			}
			
			
			//Set the data required by the response page
			req.setAttribute( "Origin", origin );
			req.setAttribute( "Destination", destination );
			req.setAttribute( "Departing", departureMM + " " + departureDD + " " + departureYY + " " + timeOfDeparture);
			req.setAttribute( "Returning", returnMM + " " + returnDD + " " + returnYY + " " + timeOfArrival );
			req.setAttribute( "NoOfPassengers", passengerCount );
			
			
			//Forward response back to the Presentation Layer
			RequestDispatcher view = req.getRequestDispatcher("TravelRequestAppConfirmation.jsp");
			view.forward(req, res);
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void loadDateValues( HttpServletRequest req, HttpServletResponse res ) {
		
		try {
			ArrayList<Integer> dateValues = travelFormLogic.getDateValues();
			
			if(dateValues!=null) {
				
				for(int i=0; i<dateValues.size(); i++) {
					req.setAttribute( "DateValue"+i, dateValues.get(i) );
				}
				
				req.setAttribute("NumOfDateValues", dateValues.size());
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void loadMonthValues( HttpServletRequest req, HttpServletResponse res ) {
		
		try {
			ArrayList<String> monthValues = travelFormLogic.getMonthValues();
			
			if(monthValues!=null) {
				
				for(int i=0; i<monthValues.size(); i++) {
					req.setAttribute("MonthValue"+i, monthValues.get(i) );
				}
				
				req.setAttribute("NumOfMonthValues", monthValues.size());
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	
	public void loadYearValues( HttpServletRequest req, HttpServletResponse res ) {
		
		try {
			ArrayList<Integer> yearValues = travelFormLogic.getYearValues();
			
			if(yearValues!=null) {
				
				for(int i=0; i<yearValues.size(); i++) {
					req.setAttribute("YearValue"+i, yearValues.get(i) );
				}
				
				req.setAttribute("NumOfYearValues", yearValues.size());
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void loadTimeValues( HttpServletRequest req, HttpServletResponse res ) {
		
		try {
			ArrayList<String> timeValues = travelFormLogic.getTimeValues();
			
			if(timeValues!=null) {
				
				for(int i=0; i<timeValues.size(); i++) {
					req.setAttribute("TimeValue"+i, timeValues.get(i) );
				}
				
				req.setAttribute("NumOfTimeValues", timeValues.size());
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void loadPassengerValues( HttpServletRequest req, HttpServletResponse res ) {
		
		try {
			ArrayList<Integer> passengerValues = travelFormLogic.getPassengerValues();
			
			if(passengerValues!=null) {
				
				for(int i=0; i<passengerValues.size(); i++) {
					req.setAttribute("PassengerValue"+i, passengerValues.get(i) );
				}
				
				req.setAttribute("NumOfPassengerValues", passengerValues.size());
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	//This part has not been implemented since it is not part of the requirement
	public void viewTravelRequestDetails(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	//This part has not been implemented since it is not part of the requirement
	public void deleteTravelRequestDetails(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
