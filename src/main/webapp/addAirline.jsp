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
<title>Add Airline</title>
</head>
<body>
	<div class="text-center">
			<h2>Add New Airline</h2>
		</div>
<form method="post" action="addAirline">


<table class="table table-bordered text-center" style="width: 500px; margin-left: auto; margin-right: auto; margin-top: 40px; margin-bottom: 40px">
<tr><td>Enter Airline Name :</td><td><input class="form-control" type="text" name="airlineName"></td></tr>

</table>
<div class="text-center"><input class="btn btn-primary" type="submit" value="Submit"></div>
</form>
</body>
</html>