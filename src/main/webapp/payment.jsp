<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String seat=request.getParameter("avaliable_seats");
int price=(int)session.getAttribute("price");
session.setAttribute("seat", seat);
%>>
<form method="post" action="SaveBooking">
Total Price :<%= price%>
<table>
<th>Payment</th>
<tr><td>Name On Card:</td><td><input type="text" name="FirstName"></td></tr>
<tr><td>Card Number:</td><td><input type="text" name="CardNumber"></td></tr>
<tr><td>Expiry Date :</td><td><input type="text" name="ExpiryDate"></td><td>Security code:</td><td><input type="text" name="securitycode"></td></tr>
<tr><td></td><td><input type="submit" value="Pay"></td></tr>
</table>
</form>
</body>
</html>