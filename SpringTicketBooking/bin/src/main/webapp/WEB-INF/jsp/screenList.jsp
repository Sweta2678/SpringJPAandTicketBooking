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

<title>Screen List</title>
</head>
<body>

	<div class="container">
		<table class="table table-striped">
			<caption>Your screen List</caption>
			<thead>
				<tr>
					<th>Screen Name</th>
					<th>Platinum seats</th>
					<th>Golden seats</th>
					<th>Silver seats</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${screens}" var="screen" >
					<tr>
						<td>${screen.screen_name}</td>
						<td>${screen.platinum_seat}</td>
						<td>${screen.gold_seat}</td>
						<td>${screen.silver_seat}</td>
						<td><a type="button" class="btn btn-success"
							href="/updateScreen?screen_id=${screen.screen_id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/deleteScreen?screen_id=${screen.screen_id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/movieAdd">Add Movie</a>
		</div>

		<div>
			<a class="button" href="/screenAdd">Add Screen</a>
		</div>
		<div>
			<a class="button" href="/movieShowAdd">Add Movie Show</a>
		</div>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!-- 		<script -->
	<!-- 			src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script> -->
</body>
</html>