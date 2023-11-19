<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.cignex.ticketBooking.model.Seat"%>
<%@page import="com.cignex.ticketBooking.model.Screen"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookedSeat</title>
</head>
<body>
<div class="form-group" style="margin: 10px; color:#334d4d;">
<h2 align="center"><font color=" black"><i>Booking Confirmed</i></font></h2>
<i></i>
<table border="1" height="50%" width="50%" align="center">
<tr><td colspan=3 align="center" ><b > Your booked seats are </b></td> </tr></br>
<tr>
<td align="center">Platinum Seat</td>

<td  align="center">Gold Seat</td>

<td  align="center">Silver Seat</td>
</tr>
<tr>
<td align="center">${platinum_seat}</td>
<td align="center">${gold_seat}</td>
<td align="center"> ${silver_seat}</td>
</tr>
</table>
</div>
<div align="center"><i> <font color=" black" ><i>Thank you for booking show!!</font></i></div>
</body>




<!-- 	<div class="container"> -->
<%-- 		<form:form action="/saveDatas" method="POST" modelAttribute="seat"> --%>
<%-- 	${platinum_seat} ${gold_seat} ${silver_seat} </br> </br> --%>
	
<%-- 		</form:form> --%>
<!-- 		</div> -->
<!-- </body> -->
</html>