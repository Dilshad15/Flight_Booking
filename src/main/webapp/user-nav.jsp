<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
/* #navbarNav{
overflow: hidden;
float: right;
  display: block;
  text-decoration: none;
   position: fixed;
  padding-left: 150px;
  width: 100%;
} */
</style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#" style="color: white">UserBookFlight</a>
    <button
      class="navbar-toggler"
      type="button"
      data-mdb-toggle="collapse"
      data-mdb-target="#navbarNav"
      aria-controls="navbarNav"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <i class="fas fa-bars"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="user-home.jsp" style="color: white">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="TicketDtls.jsp" style="color: white">MyTicket</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="userlogout" style="color: white">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>