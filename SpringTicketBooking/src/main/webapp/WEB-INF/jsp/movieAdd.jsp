<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Movie</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Add Movie</h3>
					</div>
					<div class="panel-body">
						<form:form action="/addMovie" method="POST" modelAttribute="movie"
							enctype="multipart/form-data">
							<fieldset>
								<div class="form-group">
									<form:input path="id" type="hidden" class="form-control"/>
								</div>
								<div class="form-group">
								<form:input path="name" type="text" class="form-control" placeholder="Movie Name"/>
								</div>
								<div class="form-group">
								<form:input path="description" type="text" class="form-control" placeholder="Description"/>
								</div>
								  <div class="form-group">
<!-- 								  <input type="file" name="image" /> -->
                                    <form:input class="form-control" path="image" type="file" placeholder="Upload Image"/>
                                </div>
								<div>
									<button type="submit" class="btn btn-success">Add Movie</button>
								</div>
								<!-- Change this to a button or input when using this as a form -->
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>




<!-- 	<div class="container"> -->

<!-- 		<fieldset class="form-group"> -->
<%-- 			<form:input path="id" type="hidden" class="form-control" /> --%>
<!-- 		</fieldset> -->
<!-- 		<fieldset class="form-group"> -->
<!-- 			<label>Name</label> -->
<%-- 			<form:input path="name" type="text" class="form-control" /> --%>
<!-- 		</fieldset> -->
<!-- 		<fieldset class="form-group"> -->
<!-- 			<label>Description</label> -->
<%-- 			<form:input path="description" type="text" class="form-control" /> --%>
<!-- 		</fieldset> -->

<!-- 		<fieldset class="form-group"> -->
<!-- 			<label>Upload Image</label> <input type="file" name="image" /><br /> -->
<!-- 			<br /> -->
<!-- 		</fieldset> -->
<!-- 		<button type="submit" class="btn btn-success">Add Movie</button> -->


	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>