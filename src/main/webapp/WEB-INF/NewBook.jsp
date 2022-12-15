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
<title>New Book</title>
</head>
<body>
	<div class="container">
		<a href="/books" class="btn btn-primary my-3">back to the shelves</a>
		<p class="display-3">Add a Book to the shelf!</p>
		<form:form action="/books/new" method="post" modelAttribute="book">
			<form:input type="hidden" path="user" value="${user_id}" />
			<div class="form-group">
				<label>Title</label>
				<form:input path="title" class="form-control" placeholder="Fool Me Once" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div class="form-group">
				<label>Author</label>
				<form:input path="author" class="form-control" placeholder="Harlen Coben" />
				<form:errors path="author" class="text-danger" />
			</div>
			<div class="form-group">
				<label>Description</label>
				<form:textarea path="description" class="form-control" placeholder="Suspenseful, great story telling" rows="3"/>
				<form:errors path="description" class="text-danger" />
			</div>
			<button type="submit" class="btn btn-primary mt-3">Submit</button>
		</form:form>
	</div>
</body>
</html>