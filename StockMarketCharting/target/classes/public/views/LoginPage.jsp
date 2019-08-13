<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
html {
	height: 100%;
}
body {
	background-image:
		url(https://images.unsplash.com/photo-1563986768711-b3bde3dc821e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=748&q=80);
	margin: 0;
	padding: 0;
	background-repeat: no-repeat;
	background-size: 100% 100%;
	height: 100%;
}
</style>
</head>
<body>

	<div class="container">
		<div class="row" style="margin:100px auto;">
			<div class=" card col-md-6 offset-md-3" style="border:none;background:rgba(255,255,255,0.4);color:white;">

				<div class="card-body">
				<div class="text-center" style="border:none;color:white;">
					<h4>Login Application</h4>
					<hr>
				</div>
					<form id="user_form" action="/StockExchange/login/validate"
						method="POST" class="form">
						<div class="form-group">
							<label for="name">Username:</label> <input type="text"
								class="form-control" id="name" required placeholder="Enter username"
								name="username" style="background:background:rgba(255,255,255,0.4);">
						</div>

						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password"
								class="form-control" id="pwd" required placeholder="Enter password"
								name="password">
						</div>
						<div class="row">
						<input id="confirm_user" type="submit" class="btn form-control col-md-4 offset-md-4" value="Login" style="background:#4db6ac;color:white;"/>
						</div>

						<div class="etc-login-form text-center">
							<p>
								forgot your password? <a
									href="/StockExchange/login/forgot">click here</a>
							</p>
						</div>
					</form>
				</div>
				<div class="card-footer">
					<div class="row" style="float:right;">
						 <a href="/StockExchange/login/signup"
							>
							<button id="confirm_user" type="submit" class="btn btn-primary form-control">Register
								User</button>
						</a>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>