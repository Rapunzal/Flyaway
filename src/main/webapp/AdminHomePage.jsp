<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Administration</title>
</head>
<body>
<div class="text-center">
<h2>Administrative Operations</h2>
</div>

<% String name=request.getParameter("username"); %>
<% session.setAttribute("name1",name); %>
<% 	 String name1=(String)session.getAttribute(name); %>






<h3 style="text-align: right;margin-right: 30px;">Welcome <%= name %></h3>


<table class="table table-bordered text-center" style="width: 400px; margin-left: auto; margin-right: auto; margin-top: 160px; margin-bottom: 40px">
<tr>
<td>
<form method="post" action="ListOfPlaces">
<input class="btn-lg btn-default" type="submit" value="Master List of Places">
</form>
</td>
<td>
<form method="post" action="ListOfAirLines">
<input  class="btn-lg btn-default" type="submit" value="Master List of AirLines">
</form>
</td>

<td>
<form method="post" action="ListOfFlight">
<input  class="btn-lg btn-default" type="submit" value="Master List of Flights">
</form>
</td>

<td>
<form method="post" action="changePassword.jsp">
<input  class="btn-lg btn-default" type="submit" value="Change Password">
</form>
</td>


</table>

</body>
</html>