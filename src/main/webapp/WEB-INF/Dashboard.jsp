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
<title>User Dashboard</title>
</head>
<body>
	<div class="container">
		<div class="d-flex gap-2">
			<a href="/logout" class="btn btn-primary my-3">Log Out</a>
			<a href="/books/new" class="btn btn-primary my-3">Add Book</a>
		</div>
		<p class="display-3">User Dashboard: <c:out value="${user.name}"/></p>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">Title</th>
		      <th scope="col">Author</th>
		      <th scope="col">User</th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach var="book" items="${allBooks}">
			    <tr>
			    	<td>${book.bookId}</td>
			      	<td><a href="/books/${book.bookId}"><c:out value="${book.title}" /></a></td>
			      	<td><c:out value="${book.author}" /></td>
			      	<td><c:out value="${book.user.name}" /></td>
			    </tr>
			</c:forEach>
		  </tbody>
		</table>
	</div>
</body>
</html>