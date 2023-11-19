<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Movie Show List</title>
</head>
<body>

	<div class="container">
		<table class="table table-striped">
			<caption>Your Movie List</caption>
			<thead>
				<tr>
					<th>Movie Name</th>
					<th>Screen Name</th>
					<th>Date</th>
					<th>Time</th>
					<th>Platinum Price</th>
					<th>Gold Price</th>
					<th>Silver Price</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${movieshow}" var="ms">
					<tr>
						<td>${ms.movie.name}</td>
						<td>${ms.screen.screen_name}</td>
						<td>${ms.show_date}</td>
						<td>${ms.show_time}</td>
						<td>${ms.platinum_price}</td>
						<td>${ms.gold_price}</td>
						<td>${ms.silver_price}</td>

						<td><a type="button" class="btn btn-success"
							href="/updateMovieShow?show_id=${ms.show_id}">Update</a></td>
						<!-- 							<td><a type="button" class="btn btn-success" -->
						<%-- 							href="/movieShowUpdate?show_id=${ms.show_id}">Update</a></td> --%>
						<td><a type="button" class="btn btn-warning"
							href="/deleteMovieShow?show_id=${ms.show_id}">Delete</a></td>
<!-- 						<td><a type="button" class="btn btn-warning" -->
<%-- 							href="/seatBook?show_id=${ms.show_id}">Show Seats</a></td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/movieShowAdd">Add Movie Show</a>
			<div>
				<a class="button" href="/movieAdd">Add Movie</a> 
			</div>
			<div><a class="button"
					href="/screenAdd">Add Screen</a></div>
		</div>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!-- 		<script -->
	<!-- 			src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script> -->
</body>
</html>