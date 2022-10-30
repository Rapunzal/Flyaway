<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="addFlight">
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  url="jdbc:mysql://localhost/flyaway?useSSL=false&serverTimezone=UTC" user="root" password="Water@50%"/>
<sql:query dataSource="${db}" var="rs">
select AL_NAME from AIRLINE  ;
</sql:query>



<table>
<tr><td>Enter Flight No:</td><td><input type="text" name="flightno"></td></tr>
<tr><td>Enter Airline Name:</td><td>
<select class="form-control" name="airlinename" id="airlinename">
<c:forEach var="data" items="${rs.rows}">
<option value="<c:out value="${data.al_name}"></c:out>"><c:out value="${data.al_name}"></c:out></option>
</c:forEach>
</select>
</td></tr>
<sql:query dataSource="${db}" var="rs">
select DISTINCT (SOURCE)  from FLIGHT;
</sql:query>
<sql:query dataSource="${db}" var="rs1">
select DISTINCT DESTINATION from FLIGHT;
</sql:query>

<tr><td>Enter Source:</td><td>
<select class="form-control" name="source" id="source">
<c:forEach var="data" items="${rs.rows}">
<option value="<c:out value="${data.SOURCE}"></c:out>"><c:out value="${data.SOURCE}"></c:out></option>
</c:forEach>
</select>

</td></tr>
<tr><td>Enter Destination:</td><td>
<select class="form-control" name="destination" id="destination">
<c:forEach var="data" items="${rs1.rows}">
<option value="<c:out value="${data.DESTINATION}"></c:out>"><c:out value="${data.DESTINATION}"></c:out></option>

</c:forEach>
</select>
</td></tr>
<tr><td>Price:</td><td><input type="text" name="price"></td></tr>
<tr><td>Seat Capacity:</td><td><input type="text" name="seatCapacity"></td></tr>
<tr><td></td><td><input type="submit" value="Add Flight"></td></tr>
</table>
</form>

</body>
</html>