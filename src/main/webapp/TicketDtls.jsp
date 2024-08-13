<%@page import="java.util.List"%>
<%@page import="com.jsp.Flight_Ticket_Booking_Project.dao.UserFlightBookingDao"%>
<%@page import="com.jsp.Flight_Ticket_Booking_Project.dto.AdminAddFlight"%>
<%@page import="com.jsp.Flight_Ticket_Booking_Project.dto.UserBookFlight"%>
<%@page import="com.jsp.Flight_Ticket_Booking_Project.dao.AdminAddFlightDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Book Flight</title>
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css"
  rel="stylesheet"
/>
<style>

  @page {
            size: A4;
            margin: 10px;
        }
        
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            padding: 0px;
        }
        
        .ticket {
        margin-Top:10px;
        margin-left:300px;
            width: 595px; /* A4 width in pixels */
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            overflow-y: auto; /* Enable vertical scrolling */
            height: 100vh; /* Set height to viewport height */
        }
        
        .ticket-header {
            text-align: center;
            margin-bottom: 20px;
        }
        
        .ticket-details {
            margin-bottom: 20px;
        }
        
        .ticket-details p {
            margin: 5px 0;
        }

        .t{
        width:100%;
        hight:100vh;
        object-fit:cover;
        
        }
        .nav{
          position: -webkit-sticky; /* Safari */
  position: sticky;
  top: 0;
        }
        .pdf{
        margin-left:346px;
        background-color:red;
        text-clour:red;
        }
</style>
</head>
<body>

   <%
     HttpSession sesssion = request.getSession();
     Object attribute = sesssion.getAttribute("user");
     String bookedBy=(String)attribute;
     UserFlightBookingDao ufBookingDao=new UserFlightBookingDao();
     List<UserBookFlight> ticketDtls=ufBookingDao.getTicketBookinDtls(bookedBy);
   %>

      <!-- Navbar -->
      <section class="t"
  style="background-image: url('https://s1.1zoom.me/big0/623/430889-Kysb.jpg');">
  
<jsp:include page="user-nav.jsp"></jsp:include>
<% 
for( UserBookFlight details:ticketDtls){%>
<div class="ticket">
        <h1>Airline Ticket</h1>
        
        <div class="passenger-info">
            <h2>Passenger Information:</h2>
            <p>Name: <%=details.getName() %></p>
            <p>Age: <%=details.getAge() %></p>
            <p>Gender:<%=details.getGender() %></p>
        </div>
        
        <div class="flight-info">
            <h2>Flight Information:</h2>
            <p>Flight Number:<%=details.getFlightNumber() %></p>
            <p>PNR:<%=details.getPnr() %></p>
            <p>Price:<%=details.getPrice() %></p>
            <p>Departure Time: 08:00 AM</p>
        </div>
        
        <div class="seat-info">
            <h2>Seat Information:</h2>
            <p>Seat Number: 15A</p>
            <p>Class: Economy</p>
        </div>
        <div class="pdf">
        <form action="generatePDF" method="post">
            <button type="submit">Download Ticket as PDF</button>
        </form>
        </div>
        
        
    </div>
    <%} %>
  
  
</section>
</body>
</html>