package com.jsp.Flight_Ticket_Booking_Project.controller;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.Flight_Ticket_Booking_Project.dto.AdminAddFlight;
import com.jsp.Flight_Ticket_Booking_Project.service.AdminAddFlightService;
@WebServlet("/adminAddFlight")
public class AdminAddFlightController extends HttpServlet
{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	   AdminAddFlight addFlight=new AdminAddFlight();
	   AdminAddFlightService service=new AdminAddFlightService();
	   
	   int flightNumber=Integer.parseInt(req.getParameter("flightnumber"));
	   String flightName=req.getParameter("flightname");
	   String flightSource=req.getParameter("flightSource");
	   String flightDestination=req.getParameter("flightDestination");
	   String departureTime=req.getParameter("departureTime");
	   String arrivalTime=req.getParameter("arrivalTime");
	   double flightEconomicTicketPrice=Double.parseDouble(req.getParameter("flighteconomicPrice"));
	   double flightBusinessTicketPrice=Double.parseDouble(req.getParameter("flightbusinessPrice"));
	   
	   DateFormat dateFormat=new SimpleDateFormat("HH:MM");
	   Time aTime=null;
	   Time dTime=null;
	   try {
		aTime=new Time(dateFormat.parse(arrivalTime).getTime());
		dTime=new Time(dateFormat.parse(departureTime).getTime());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   addFlight.setFlightNumber(flightNumber);
	   addFlight.setFlightName(flightName);
	   addFlight.setFlightSource(flightSource);
	   addFlight.setFlightDestination(flightDestination);
	   addFlight.setDepartureTime(aTime);
	   addFlight.setArrivalTime(dTime);
	   addFlight.setFlightEconomicPrice(flightEconomicTicketPrice);
	   addFlight.setFlightBusinessPrice(flightBusinessTicketPrice);
	   
	   service.addAdminFlight(addFlight);
	   RequestDispatcher dispatcher=req.getRequestDispatcher("admin-add-flight.jsp");
	   dispatcher.forward(req, resp);
}
}
