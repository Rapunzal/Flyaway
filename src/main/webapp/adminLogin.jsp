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
<title>Admin Login</title>
</head>
<body>
<% if(request.getAttribute("message")!=null)
	out.println(request.getAttribute("message"));
%>
<div class="align-items-center">

		<div class="text-center">
			<h2>Administrator Login</h2>
		</div>

		<form method="post"  action="Login">
			<div class="container" style="text-align: center;">
			
				<table class="table table-bordered" style="width: 400px; margin-left: auto; margin-right: auto; margin-top: 40px; margin-bottom: 40px">
					
					<tbody class="text-center">
						<tr>
							<td>Name :</td>
							<td><input class="form-control" type="text" name="username"></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input class="form-control" type="password" name="password"></td>
						</tr>

						
					</tbody>
				</table>
												<div class="form-row text-center">
									<input type="submit" class="btn btn-primary"
										value="Login">
								</div>
			</div>
		</form>


	</div>
</body>
</html>