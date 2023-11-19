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

<title>Movie List</title>
</head>
<body>

	<div class="container">
		<table class="table table-striped" enctype="multipart/form-data">
			<caption>Your Movie List</caption>
			<thead>
				<tr>
					<th>Movie Name</th>
					<th>Description</th>
					<th>Movie Image</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${movies}" var="movie">
					<tr>
						<td>${movie.name}</td>
						<td>${movie.description}</td>
						<%-- 						<td>${movie.image}</td> --%>
						<%-- 						<td><img border="1" src="images/${movie.image}" height="160" width="160"/></td> --%>
						<td><img src="data:image/jpg;base64,${movie.image}"
							border="20px" width="100" height="100" /></td>

						<td><a type="button" class="btn btn-success"
							href="/updateMovie?id=${movie.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/deleteMovie?id=${movie.id}">Delete</a></td>
						<!-- 							<td><a type="button" class="btn btn-danger" -->
						<%-- 							href="/movieShowAdd?id=${movie.id}">Book Show</a></td> --%>
						<!-- 							<td><a type="button" class="btn btn-danger" -->
						<%-- 							href="/movieShowAdd?id=${movie.id}">Book Show</a></td> --%>
						<!-- 						<td><a type="button" class="btn btn-danger" -->
						<%-- 							href="/movieShowAdd?id=${movie.id}">Book Show</a></td> --%>
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