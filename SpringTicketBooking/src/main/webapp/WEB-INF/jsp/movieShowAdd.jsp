<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Movie Shows</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Add Show</h3>
					</div>
					<div class="panel-body">
						<form:form action="/addMovieShow" method="POST"
							modelAttribute="movieshow">
							<fieldset>
								<div class="form-group">
									<form:input path="show_id" type="hidden" class="form-control" />
								</div>
								<div class="form-group">
									<form:label path="movie">Movie Name</form:label>
									<form:select path="movie">
										<c:forEach items="${movies}" var="movie">
											<form:option value="${movie.id}">${movie.name}</form:option>
											<c:if test="${movieshow.movie.id}== ${movie.id}">
												<form:input path="movie.name" type="text"
													class="form-control" />
											</c:if>
										</c:forEach>
									</form:select>
								</div>
								<div class="form-group">
									<form:label path="screen">Screen Name</form:label>
									<form:select path="screen">
										<c:forEach items="${screens}" var="screen">
											<form:option value="${screen.screen_id }">${screen.screen_name}</form:option>
										</c:forEach>
									</form:select>
								</div>
								<div class="form-group">
									<label>Show Time</label>
									<form:input path="show_date" type="date" class="form-control" />
								</div>

								<div class="form-group">

									<label>Time</label>
									<input name="showtime" type="time" class="form-control" />
								</div>
								<div class="form-group">
									<label>Platinum Price</label>
									<form:input path="platinum_price" type="number"
										class="form-control" />
								</div>
								<div class="form-group">
									<label>Gold Price</label>
									<form:input path="gold_price" type="number"
										class="form-control" />
								</div>
								<div class="form-group">
									<label>Silver Price</label>
									<form:input path="silver_price" type="number"
										class="form-control" />
								</div>
								<div>
									<button type="submit" class="btn btn-success">Add Movie
										Show</button>
								</div>
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

<!-- 	<div class="container"> -->
<%-- 		<form:form action="/addMovieShow" method="POST" --%>
<%-- 			modelAttribute="movieshow"> --%>
<!-- 			<fieldset class="form-group"> -->
<%-- 				<form:input path="show_id" type="hidden" class="form-control" /> --%>
<!-- 			</fieldset> -->


<!-- 			<fieldset class="form-group"> -->
<%-- 				<form:label path="movie">Movie Name</form:label> --%>
<%-- 				<form:select path="movie"> --%>
<%-- 					<c:forEach items="${movies}" var="movie"> --%>
<%-- 						<form:option value="${movie.id}">${movie.name}</form:option> --%>
<%-- 						<c:if test="${movieshow.movie.id}== ${movie.id}"> --%>
<%-- 							<form:input path="movie.name" type="text" class="form-control" /> --%>
<%-- 						</c:if> --%>
<%-- 					</c:forEach> --%>
<%-- 				</form:select> --%>
<!-- 			</fieldset> -->
<!-- 			<fieldset class="form-group"> -->
<%-- 				<form:label path="screen">Screen Name</form:label> --%>
<%-- 				<form:select path="screen"> --%>
<%-- 					<c:forEach items="${screens}" var="screen"> --%>
<%-- 						<form:option value="${screen.screen_id }">${screen.screen_name}</form:option> --%>
<%-- 					</c:forEach> --%>
<%-- 				</form:select> --%>
<!-- 			</fieldset> -->
<!-- 			<fieldset class="form-group"> -->
<!-- 				<label>Date</label> -->
<%-- 				<form:input path="show_date" type="date" class="form-control" /> --%>
<!-- 			</fieldset> -->
<!-- 			<fieldset class="form-group"> -->
<!-- 				<label>Time</label> <input name="showtime" type="time" -->
<!-- 					class="form-control" /> -->
<!-- 			</fieldset> -->
<!-- 			<fieldset class="form-group"> -->
<!-- 				<label>Platinum Price</label> -->
<%-- 				<form:input path="platinum_price" type="number" class="form-control" /> --%>
<!-- 			</fieldset> -->
<!-- 			<fieldset class="form-group"> -->
<!-- 				<label>Gold Price</label> -->
<%-- 				<form:input path="gold_price" type="number" class="form-control" /> --%>
<!-- 			</fieldset> -->
<!-- 			<fieldset class="form-group"> -->
<!-- 				<label>Silver Price</label> -->
<%-- 				<form:input path="silver_price" type="number" class="form-control" /> --%>
<!-- 			</fieldset> -->
<!-- 			<button type="submit" class="btn btn-success">Add Movie Show</button> -->

<%-- 		</form:form> --%>
<!-- 	</div> -->
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>