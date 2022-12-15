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
<title>Book Page</title>
</head>
<body>
	<div class="container">
		<a href="/books" class="btn btn-primary my-3">back to the shelves</a>
		<p class="display-3"><c:out value="${book.title}"/></p>
		<h4>By <c:out value="${book.author}"/></h4>
		<c:if test="${book.user.userId == user_id}">
			<div class="d-flex gap-2">
				<a href="/books/${book.bookId}/edit" class="btn btn-primary">Edit</a>
				<form action="/books/${book.bookId}/delete" method="post">
					<input type="hidden" value="delete" name="_method"/>
					<input type="submit" value="Delete" class="btn btn-danger" />
				</form>
			</div>
		</c:if>
	</div>
</body>
</html>