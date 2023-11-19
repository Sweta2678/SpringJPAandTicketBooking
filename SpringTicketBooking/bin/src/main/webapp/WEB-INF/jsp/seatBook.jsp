<%@page import="java.util.ArrayList"%>
<%@page import="com.cignex.ticketBooking.model.MovieShow"%>
<%@page import="java.util.List"%>
<%@page import="com.cignex.ticketBooking.model.Screen"%>
<%@page import="com.cignex.ticketBooking.model.Seat"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seats of Movie</title>
</head>
<body>

	<div class="container">
		<form:form action="/saveData" method="POST" modelAttribute="seat">

			<%
				List<Screen> s = (List<Screen>) request.getAttribute("movieshw");

					List<Seat> bt = (List<Seat>) request.getAttribute("seatshow");
					
					int platinum_price=  ((int)request.getAttribute("platinum_price"));
					
					int gold_price= ((int)request.getAttribute("gold_price"));
					
					int silver_price= ((int)request.getAttribute("silver_price"));

					int showId = Integer.parseInt(request.getParameter("show_id"));
					int total_price=0;
			%>
		
		
			
		<%-- 	<%=showId %> --%>
			
			<!-- This is to store the selected seat from user in gseat, as bt has all data and that is iterated through for each and value is in b  -->
	<%
				List<String> pseat = new ArrayList<String>();

					for (Seat b : bt) {
						for (int i = 0; i < b.getPlatinum_seat().size(); i++) {
							pseat.add(b.getPlatinum_seat().get(i));
						}
					}
			%>

			<%
				List<String> gseat = new ArrayList<String>();

					for (Seat b : bt) {
						for (int i = 0; i < b.getGold_seat().size(); i++) {
							gseat.add(b.getGold_seat().get(i));
						}

					}
			%>
			<%
				List<String> sseat = new ArrayList<String>();

					for (Seat b : bt) {
						for (int i = 0; i < b.getSilver_seat().size(); i++) {
							sseat.add(b.getSilver_seat().get(i));
						}

					}
			%>
			<%
				for (Screen ss : s) {
			%>

			<%
				for (int i = 1; i <= ss.getPlatinum_seat(); i++) {
			%>
			<div class="col-lg-1">
				<p>
					P<%=i%>

					<%
						int flag = 0;
									for (int pl = 0; pl < pseat.size(); pl++) {
										if (pseat.get(pl).equals("P" + i)) {
											flag = 1;
					%>
					<input type="checkbox" name="platinum_seat_checked" value="P<%=i%>"
						disabled="disabled" checked="checked" />
				</p>
				<%
					}
				%>

				<%
					}
								if (flag == 0) {
				%>
				<input type="checkbox" name="platinum_seat" value="P<%=i%>"
					onclick="pcheckboxes(<%=platinum_price%>);" />
				<%
					}
								flag = 0;
				%>
			</div>
			<%
				}
			%>
			<%
				for (int i = 1; i <= ss.getGold_seat(); i++) {
			%>

			<div class="col-lg-1">
				<p>
					G<%=i%>
					<%
						int flag = 0;
									for (int go = 0; go < gseat.size(); go++) {
										if (gseat.get(go).equals("G" + i)) {
											flag = 1;
					%>

					<input type="checkbox" name="gold_seat_checked" value="G<%=i%>"
						disabled="disabled" checked="checked" />
				</p>
				<%
					}
				%>
				<%
					}
								if (flag == 0) {
				%>
				<input type="checkbox" name="gold_seat" value="G<%=i%>"
					onclick="gcheckboxes(<%=gold_price%>);" />
				<%
					}
								flag = 0;
				%>
			</div>
			<%
				}
			%>
			<%
				for (int i = 1; i <= ss.getSilver_seat(); i++) {
			%>
			<div class="col-lg-1">
				<p>
					S<%=i%>
					<%
						int flag = 0;
									for (int si = 0; si < sseat.size(); si++) {
										if (sseat.get(si).equals("S" + i)) {
											flag = 1;
					%>

					<input type="checkbox" name="silver_seat_checked" value="S<%=i%>"
						disabled="disabled" checked="checked" />
				</p>
				<%
					}
				%>

				<%
					}
								if (flag == 0) {
				%>
				<input type="checkbox" name="silver_seat" value="S<%=i%>"
					onclick="scheckboxes(<%=silver_price%>)" />
				<%
					}
								flag = 0;
				%>
			</div>
			<%
				}
			%>
			<%
				}
			%>
			<Script>
			
				
			
				function pcheckboxes(platinum_price) {
					
					var inputElems = document
							.getElementsByName("platinum_seat"), count = 0;

					for (var i = 0; i < inputElems.length; i++) {
						if (inputElems[i].type == "checkbox"
								&& inputElems[i].checked == true) {
							count++;
						}
					}
// 					alert(platinum_price);
// 					alert(count*platinum_price);
					total_pl_price=count*platinum_price;
					console.log(count);
				}
			</script>
			<Script>
				function gcheckboxes(gold_price) {
					var inputElems = document.getElementsByName("gold_seat"), count = 0;

					for (var i = 0; i < inputElems.length; i++) {
						if (inputElems[i].type == "checkbox"
								&& inputElems[i].checked == true) {
							count++;

						}
					}
// 					alert(count*gold_price);
					total_gold_price=count*gold_price;
					console.log(count);
				}
			</script>
			<Script>
				function scheckboxes(silver_price) {
					var inputElems = document.getElementsByName("silver_seat"), count = 0;

					for (var i = 0; i < inputElems.length; i++) {
						if (inputElems[i].type == "checkbox"
								&& inputElems[i].checked == true) {
							count++;
						}
					}
// 					alert(count*silver_price);
					
					total_silver_price=count*silver_price;
					console.log(count);
		
				}
			</script>
			<script type="text/javascript">
			
			function totalprice(platinum_price,gold_price,silver_price)
			{
				pcheckboxes(platinum_price);
				gcheckboxes(gold_price);
				scheckboxes(silver_price);
				
			var tp=total_pl_price;
			var tp1=total_gold_price;
			var tp2=total_silver_price;
			
			alert(" Your total Price : "+(tp+tp1+tp2));
			}

			</script>
			<input type="hidden" name="show_id" value="<%=showId%>">
			<input type="submit" onclick="totalprice(<%=platinum_price %>,<%=gold_price %>,<%=silver_price %>)"></button>
		</form:form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>