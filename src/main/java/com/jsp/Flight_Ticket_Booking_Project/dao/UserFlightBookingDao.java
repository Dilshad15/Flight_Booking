package com.jsp.Flight_Ticket_Booking_Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.Flight_Ticket_Booking_Project.connection.FlightConnection;
import com.jsp.Flight_Ticket_Booking_Project.dto.UserBookFlight;

public class UserFlightBookingDao 
{
   Connection connection=FlightConnection.getFlightConnection();
   
   public UserBookFlight saveBookingDetails(UserBookFlight userBookFlight)
   {
	   String insertQuery="Insert into flightbookingdetails values(?,?,?,?,?,?,?,?,?)";
	   
	   try {
		PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
		preparedStatement.setLong(1, userBookFlight.getPnr());
		preparedStatement.setString(2, userBookFlight.getName());
		preparedStatement.setString(3, userBookFlight.getEmail());
		preparedStatement.setLong(4, userBookFlight.getPhone());
		preparedStatement.setInt(5, userBookFlight.getAge());
		preparedStatement.setString(6, userBookFlight.getGender());
		preparedStatement.setDouble(7, userBookFlight.getPrice());
		preparedStatement.setInt(8, userBookFlight.getFlightNumber());
		preparedStatement.setString(9,userBookFlight.getBookedBy());
		
		preparedStatement.execute();
		return userBookFlight;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return null;
   }
   public List<UserBookFlight> getTicketBookinDtls(String user) {
	   String sql="Select * from flightbookingdetails where bookedBy=?";
	   List <UserBookFlight> list=new ArrayList<>();
	  
	   try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,user);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			 UserBookFlight userBookFlight=new UserBookFlight();
			userBookFlight.setPnr(rs.getLong("pnr"));
			userBookFlight.setName(rs.getString("name"));
			userBookFlight.setEmail(rs.getString("email"));
			userBookFlight.setPhone(rs.getLong("phone"));
			userBookFlight.setAge(rs.getInt("age"));
			userBookFlight.setGender(rs.getString("gender"));
			userBookFlight.setPrice(rs.getDouble("price"));
			userBookFlight.setFlightNumber(rs.getInt("flightNumber"));
			list.add(userBookFlight);
		
			
		}
		return list;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
   }
}
