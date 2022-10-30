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
<title>Passenger Registration</title>
</head>
<body>
<div class="text-center"><h2>Primary Passenger Registration</h2></div>
<form method="post" action="PassengerRegistrationSave">
<table class="table table-bordered text-center" style="width: 500px; margin-left: auto; margin-right: auto; margin-top: 40px; margin-bottom: 40px">

<tr><td>First Name</td><td><input class="form-control" type="text" name="fname"></td></tr>
<tr><td>Last Name</td><td><input  class="form-control" type="text" name="lastname"></td></tr>
<tr><td>Date Of Birth</td><td><input  class="form-control" type="date" name="dateOfBirth"></td></tr>
<tr><td>Identification Number</td><td><input  class="form-control" type="text" name="idNo"></td></tr>
<tr><td>Email Id</td><td><input  class="form-control" type="text" name="emailId"></td></tr>
<tr><td>Password</td><td><input  class="form-control" type="password" name="password"></td></tr>

</table>
<div class="text-center"><input  class="btn btn-primary center" type="submit" value="Register" ></div>
</form>

</body>
</html>