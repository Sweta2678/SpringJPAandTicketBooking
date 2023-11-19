<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cignex.ticketBooking.model.MovieShow"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background: url('jsp/images/uri.jpg') no-repeat fixed center;
}
</style>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Movie</title>
</head>
<body>
<!-- <div class="container"> -->


<!-- 		<div class="row"> -->


<!-- 			<div class="card-deck"> -->

<%-- 				<c:forEach items="${movies}" var="movie"> --%>
<!-- 					<div class="card"> -->

<%-- 						<c:url var="editUrl" value="/movie/get"> --%>
<%-- 							<c:param name="id" value="${movie.id }"></c:param> --%>
<%-- 						</c:url> --%>
<%-- 						<c:url var="deleteUrl" value="/movie/delete/${l.id}"></c:url> --%>
<%-- 						<center> --%>
<!-- 							<img -->
<!-- 								class="pinned-repo-item p-3 mb-3 border border-gray-dark rounded-1 public source" -->
<!-- 								width="250" height="200" -->
<%-- 								src="data:image/jpg;base64,${movie.image}" border="20px" alt="${movie.image}"/> --%>
<%-- 						</center> --%>
<!-- 						<div class="card-body"> -->
<%-- 							<div class="clear" align="center"">${movie.name}</div> --%>
<%-- 							<div class="clear" align="center"">${movie.description}</div> --%>
<!-- 							<div class="clear" align="center""> -->
<%-- 								<a type="button" class="btn btn-sucess" href="/bookMovie?id=${movie.id}">Book Now</a> --%>
<%-- <%-- 								| | <a class="btn btn-danger" href="${deleteUrl }">DELETE</a> --%> 
<!-- 							</div> -->

<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				</c:forEach> --%>

<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->

	<div class="container">
		<div class="row">
			
				<c:forEach items="${movies}" var="movie">
					<div class="card" style="width: 18rem; display: inline-block; float: left; margin: 20px;  color: green">
						<h2 class="card-title" align="center" >${movie.name}</h2>
						<img class="card-img-top"
							src="data:image/jpg;base64,${movie.image}" alt="${movie.image}"
							border="20px" width="200" height="200">
						<div class="card-body">
							<p class="card-text style= "display: inline-block;">${movie.description}</p>
							<a href="/bookMovie?id=${movie.id}" class="btn btn-primary">Book
								Now</a> 
						</div>
					</div>
				</c:forEach>
			
		</div>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>