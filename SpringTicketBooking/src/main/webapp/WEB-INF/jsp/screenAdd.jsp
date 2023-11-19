<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
    <%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Screen</title>
</head>
<body>
<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Add Screen</h3>
					</div>
					<div class="panel-body">
						  <form:form action="/addScreen" method="POST" modelAttribute="screen">
							<fieldset>
								<div class="form-group">
									<form:input path="screen_id" type="hidden" class="form-control"/>
								</div>
								<div class="form-group">
								<form:input path="screen_name" type="text" class="form-control" placeholder="Screen Name"/>
								</div>
								<div class="form-group"><label>Platinum Seat</label>
								<form:input path="platinum_seat" type="number" class="form-control" placeholder="No. of Platinum seats"/>
								</div>
								
								 <div class="form-group"><label>Gold Seat</label>
								<form:input path="gold_seat" type="number" class="form-control" placeholder="No. of Golden seats"/>
								</div>
								<div class="form-group"><label>Silver Seat</label>
								<form:input path="silver_seat" type="number" class="form-control" placeholder="No. of Silver seats"/>
								</div>
								<div>
									<button type="submit" class="btn btn-success">Add Screen</button>
								</div>
								<!-- Change this to a button or input when using this as a form -->
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>



<!-- <div class="container"> -->
<%--     <form:form action="/addScreen" method="POST" modelAttribute="screen"> --%>
<!--      <fieldset class="form-group"> -->
<%--            <form:input path="screen_id" type="hidden" --%>
<%--                 class="form-control" /> --%>
<!--         </fieldset> -->
<!--         <fieldset class="form-group"> -->
<%--             <label>Name</label> <form:input path="screen_name" type="text" --%>
<%--                 class="form-control" /> --%>
<!--         </fieldset> -->
<!--         <fieldset class="form-group"> -->
<%--             <label>Platinum seats</label> <form:input path="platinum_seat" type="number" --%>
<%--                 class="form-control" /> --%>
<!--         </fieldset> -->
<!--         <fieldset class="form-group"> -->
<%--             <label>Golden seats</label> <form:input path="gold_seat" type="number" --%>
<%--                 class="form-control" /> --%>
<!--         </fieldset> -->
<!--         <fieldset class="form-group"> -->
<%--             <label>Silver seats</label> <form:input path="silver_seat" type="number" --%>
<%--                 class="form-control" /> --%>
<!--         </fieldset> -->
<!--         <button type="submit" class="btn btn-success">Add Screen</button> -->
        
<%--     </form:form> --%>
<!-- </div> -->
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>