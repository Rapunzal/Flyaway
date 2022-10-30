
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Date,java.text.*" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  url="jdbc:mysql://localhost/flyaway?useSSL=false&serverTimezone=UTC" user="root" password="Water@50%"/>
<% String fname=request.getParameter("fname"); %>
<% String lname=request.getParameter("lastname"); %>
<% String dob=request.getParameter("dateOfBirth");
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date utilDate = format.parse(dob);
   java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
   //System.out.println(sqlDate);
   System.out.println(sqlDate);
%>
<% String Idno=request.getParameter("idNo");

%>

<% String email=request.getParameter("emailId"); %>
<c:catch var="exception">

<sql:update dataSource="${db}" var="rs">
insert into PASSENGER (FNAME,LNAME,DOB,ID_NO,EMAILID,PASSWORD) values(?,?,?,?,?,?)
<sql:param value="${param.fname}"/>
<sql:param value="${param.lastname}"/>
<sql:param value="<%=sqlDate%>"/>
<sql:param value="${param.idNo}"/>
<sql:param value="${param.emailId}"/>
<sql:param value="${param.password}"/>
</sql:update>
<c:if test="${rs>=1}">
<font size="5" color='green'> Congratulations ! User Registered.</font>
</c:if>
</c:catch>
<c:if test="${exception!=null}">
<c:out value="Unable to insert data in database." />
</c:if>
<% RequestDispatcher rd=request.getRequestDispatcher("Booking.jsp");
rd.forward(request, response);
%>
</body>
</html>