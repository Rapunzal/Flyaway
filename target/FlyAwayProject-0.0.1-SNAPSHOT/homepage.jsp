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
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  url="jdbc:mysql://localhost/simpliLearn?useSSL=false&serverTimezone=UTC" user="root" password="Water@50%"/>

<sql:query dataSource="${db}" var="rs">
select * from employee;
</sql:query>
<form action="searchPage">


<table>
<th>Enter Travel Details to search</th>
<tr><td>
Date Of Travel :</td><td><input type="date" name="dateOfTravel"></td></tr>

<tr><td>Source Location:</td><td>

<select name="source" id="source">
<c:forEach var="data" items="${rs.rows}">
<option value="<c:out value="${data.first_name}"></c:out>"><c:out value="${data.first_name}"></c:out></option>
</c:forEach>
</select>

</td></tr>
<tr><td>Destination Location :</td><td>

<select name="destination" id="destination">
<c:forEach var="data" items="${rs.rows}">
<option value="<c:out value="${data.last_name}"></c:out>"><c:out value="${data.last_name}"></c:out></option>

</c:forEach>
</select>

</td></tr>
<tr><td>No Of Persons :</td><td><input type="number" name="numOfPerson"></td></tr>
<tr><td></td><td><input type="submit" value="Search"></td></tr>

</table>
</form>
</body>
</html>