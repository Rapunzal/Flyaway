<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
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
<title>Search Flight</title>
</head>
<body>

		<div class="text-center">
			<h2>Search Flights</h2>
		</div>

<form method="post" action="searchPage">
<div class="container" style="text-align: center;">
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  url="jdbc:mysql://localhost/flyaway?useSSL=false&serverTimezone=UTC" user="root" password="Water@50%"/>
<sql:query dataSource="${db}" var="rs">
select DISTINCT (SOURCE)  from FLIGHT;
</sql:query>
<sql:query dataSource="${db}" var="rs1">
select DISTINCT DESTINATION from FLIGHT;
</sql:query>



<table class="table table-bordered " style="width: 500px; margin-left: auto; margin-right: auto; margin-top: 40px; margin-bottom: 40px">

<tr><td>
Date of Travel :</td><td><input class="form-control" type="date" name="dateOfTravel"></td></tr>

<tr><td>Source Location:</td><td>

<select class="form-control" name="source" id="source">
<c:forEach var="data" items="${rs.rows}">
<option value="<c:out value="${data.SOURCE}"></c:out>"><c:out value="${data.SOURCE}"></c:out></option>
</c:forEach>
</select>

</td></tr>
<tr><td>Destination Location :</td><td>

<select class="form-control" name="destination" id="destination">
<c:forEach var="data" items="${rs1.rows}">
<option value="<c:out value="${data.DESTINATION}"></c:out>"><c:out value="${data.DESTINATION}"></c:out></option>

</c:forEach>
</select>

</td></tr>
<tr><td>No of Persons :</td><td><input class="form-control" type="number" name="numOfPerson"></td></tr>


</table>
<div class="text-center"><input class="btn btn-primary center" type="submit" value="Search"></div>
</div>
</form>
</body>
</html>