<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Log In/Sign Up</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<p class="display-5">Book Club</p>
			<p>A place for friends to share thoughts on books.</p>
		</div>
		<div class="row">
			<div class="col">
				<p class="display-5">Register</p>
				<form:form action="/register/user" method="post" modelAttribute="user">
					<div class="form-group">
						<label>Name</label>
						<form:input type="text" class="form-control" placeholder="Enter Name" path="name"/>
						<form:errors path="name" class="text-danger"/>
					</div>
					<div class="form-group">
						<label>Email address</label>
						<form:input type="email" class="form-control" placeholder="Enter email" path="email"/>
						<form:errors path="email" class="text-danger"/>
					</div>
					<div class="form-group">
						<label>Password</label>
						<form:input type="password" class="form-control" placeholder="Password" path="password"/>
						<form:errors path="password" class="text-danger"/>
					</div>
					<div class="form-group">
						<label>Confirm Password</label>
						<form:input type="password" class="form-control" placeholder="Password" path="confirm"/>
						<form:errors path="confirm" class="text-danger"/>
					</div>
					<button type="submit" class="btn btn-primary mt-3">Submit</button>
				</form:form>
			</div>
			<div class="col">
				<p class="display-5">Log in</p>
				<form:form action="/login/user" method="post" modelAttribute="loginUser">
					<div class="form-group">
						<label>Email address</label>
						<form:input type="email" class="form-control" placeholder="Enter email" path="email"/>
						<form:errors path="email" class="text-danger"/>
					</div>
					<div class="form-group">
						<label>Password</label>
						<form:input type="password" class="form-control" placeholder="Password" path="password"/>
						<form:errors path="password" class="text-danger"/>
					</div>
					<button type="submit" class="btn btn-primary mt-3">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>