package com.jsp.Flight_Ticket_Booking_Project.dto;

public class UserBookFlight 
{
   private long pnr;
   private String name;
   private String email;
   private long phone;
   private int age;
   private String gender;
   private double price;
   private int flightNumber;
   private String bookedBy;
public String getBookedBy() {
	return bookedBy;
}
public void setBookedBy(String bookedBy) {
	this.bookedBy = bookedBy;
}
public long getPnr() {
	return pnr;
}
public void setPnr(long pnr) {
	this.pnr = pnr;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getFlightNumber() {
	return flightNumber;
}
public void setFlightNumber(int flightNumber) {
	this.flightNumber = flightNumber;
}
   
}
