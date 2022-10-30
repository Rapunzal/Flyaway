<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
	<%@ page import = "java.lang.*"%>
	<%@ page import="java.text.SimpleDateFormat" %>>
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
<title>Booking Details</title>
</head>
<body>


<div class="text-center"><h2>Booking Details</h2></div>

<form class="text-center" method="post" action="payment.jsp">
<% 
out.println("Primary Passenger Id :"+ session.getAttribute("passId")); 
Integer n =(Integer)session.getAttribute("passId");
String fltId=(String)session.getAttribute("flightId");
int noPerson=(int)session.getAttribute("noOfPerson");
String date=(String)session.getAttribute("date");
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date utilDate = format.parse(date);
   java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
   System.out.println(sqlDate);
out.println("Primary Passenger Name : ");
%>

<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  url="jdbc:mysql://localhost/flyaway?useSSL=false&serverTimezone=UTC" user="root" password="Water@50%"/>

<sql:query dataSource="${db}" var="rs">
select *  from PASSENGER where PASSENGER_ID=?;
<sql:param value="<%=n%>"/>

</sql:query>
       <c:forEach var = "row" items = "${rs.rows}">  
          <c:out value = "${row.fname}"/>
          <c:out value = "${row.lname}"/>
         </c:forEach>
         <table class="table table-bordered text-center" style="width: 500px; margin-left: auto; margin-right: auto; margin-top: 40px; margin-bottom: 40px">
         
<sql:query dataSource="${db}" var="rs">
select distinct(f.FLT_NO),al.AL_NAME,f.SOURCE,f.DESTINATION,a.DEP_DATE,a.PRICE,a.AVAILABLE_SEATS from FLIGHT f,AVAILABILITY a ,AIRLINE al where f.AL_ID=al.AL_ID and f.FLT_NO=a.FLT_NO  and f.FLT_NO=? and a.DEP_DATE=?;
<sql:param value="<%=fltId%>"/>
<sql:param value="<%=sqlDate%>"/>
</sql:query>
       <c:forEach var = "row" items = "${rs.rows}">  
       <tr> <td>Flight Number :</td>  <td><c:out value = "${row.flt_no}"/></td></tr>
       <tr> <td>Airline Name :</td>  <td>   <c:out value = "${row.al_name}"/></td></tr>
        <tr> <td>Source :</td>  <td>  <c:out value = "${row.source}"/></td></tr>
        <tr> <td>Destination :</td>  <td>  <c:out value = "${row.destination}"/></td></tr>
         <tr> <td>Departure Date :</td>  <td> <c:out value = "${row.dep_date}"/></td></tr>
         <tr> <td>Total Price :</td>  <td> <c:out value = "${row.price}"/></td></tr>
         <tr><td>No of Person :</td><td><%= noPerson %></td></tr>
         <input type="hidden" name="flightno" value=<c:out value = "${row.flt_no}"/>>
         <input type="hidden" name="avaliable_seats" value=<c:out value = "${row.available_seats}"/>>
       
         </c:forEach>
        
         </table>
         <div class="text-center"> <input class="btn btn-primary center" type="submit" value="Book"></div>
</form>
</body>
</html>