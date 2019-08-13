<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*"%>
     <%@ page import = "java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		url(https://images.unsplash.com/photo-1516574187841-cb9cc2ca948b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80);
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
					<h4>Confirmation</h4>
					<div class="etc-login-form text-center">
						<p>
							Please check your mail :<c:out value="${mail}"/>
							<c:out value="${username}"/>
						</p>
					</div>
					<hr>
				</div>
					<form id="user_form" action="/StockExchange/<c:out value='${mail}'/>"
						method="GET" class="form">
						<div class="form-group">
							<label for="Confirmationcode">Enter the Code:</label> <input type="text"
								class="form-control" id="name" required placeholder="Enter Verification Code"
								name="code" style="background:background:rgba(255,255,255,0.4);">
						</div>


						<div class="row">
						<input id="confirm_user" type="submit" class="btn form-control col-md-4 offset-md-4" value="Verify" style="background:#4db6ac;color:white;"/>
						</div>
					</form>
				</div>

						<div class="etc-login-form text-center">
							<p>
								Confirmed ?<a
									href="/StockExchange/"> Sign in </a>
							</p>
						</div>



			</div>
		</div>
	</div>

</body>
</html>