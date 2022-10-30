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
<title>Change Password</title>
</head>
<body>

		<div class="text-center">
			<h2>Change Password</h2>
		</div>

<form method="post"   action="ChangePassword">

				<table class="table table-bordered" style="width: 400px; margin-left: auto; margin-right: auto; margin-top: 40px; margin-bottom: 40px">
					
					<tbody class="text-center">
						<tr>

<td>Old Password :</td><td><input class="form-control" type="password" name="oldpassword"></td>
</tr>

<tr>
<td>New Password :</td><td><input class="form-control" type="password" name="newpassword"></td>

</tr>

<tr>
<td>New Password :</td><td><input class="form-control" type="password" name="newpassword1"></td>

</tr>
</tbody>
				</table>
					
<div class="form-row text-center">				
<input class="btn btn-primary" type="submit" value="Change Password">
</div>


</form>
</body>
</html>