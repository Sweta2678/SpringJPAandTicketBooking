<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ include file="header.jsp"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Screen</title>
</head>
<body>
	<script>
		function checkId(id) {
			alert(show_id);
		}
	</script>
	<div class="container">
	</br>
	</br>
		<table class="table table-striped">
			<caption>Ticket booking</caption>
			<thead>
				<tr>
					<th>Movie Name</th>
					<th>Screen Name</th>
					<th>Date</th>
					<th>Time</th>
					<th>Platinum Ticket Price</th>
					<th>Gold Ticket Price</th>
					<th>Silver Ticket Price</th>
					<th>Seats</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${movieshowss}" var="mvs">
					<tr>
						<td>${mvs.movie.name}</td>
						<td>${mvs.screen.screen_name}</td>
						<td>${mvs.show_date}</td>
						<td>${mvs.show_time}</td>
						<td>${mvs.platinum_price}</td>
						<td>${mvs.gold_price }</td>
						<td>${mvs.silver_price }</td>
						<td><a href="/screenSeats?show_id=${mvs.show_id}&screen=${mvs.screen.screen_id}&platinum_price=${mvs.platinum_price}&gold_price=${mvs.gold_price}&silver_price=${mvs.silver_price}">SeatBook</a></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>