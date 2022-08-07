<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title><c:out value="${shows.title}"></c:out></title>
</head>
<body>
<div class = "container col-7">
<div class = "d-flex justify-content-evenly mt-4">
<a href ="/dashboard">Return Home</a>
<a href = "/create">Add a Show</a>
<a href = "/logout" class = "mb-5">Log Out</a>
</div>
	<h1><c:out value="${shows.title}"></c:out></h1>
	<c:set var = "owner" value = "${shows.user.id}"/>
	<c:set var = "user" value = "${userId.id}"/>
	<div>
	<h2 class = "mt-5">Posted by: <c:out value="${shows.user.name}"></c:out></h2>
	<div>
	<h2 class = "mt-5">Network by: <c:out value="${shows.network}"></c:out></h2>
	<div>
	<h3 class = "mt-5">Description: <c:out value="${shows.description}"></c:out></h3>
	</div>
	<div>
	<h3 class = "mt-5">Rating: <c:out value="${ratings.size()}"></c:out></h3>
	</div>
	<h3 class = "mt-5">Description: <c:out value="${shows.description}"></c:out></h3>
	</div>
	<div>
	<c:forEach var="rating" items="${ratings}">
	 <c:out value="${rating.showRatings}"></c:out>
	</c:forEach>
	</div>
	
<c:if test = "${owner == user}">
<a href ="/edit/${shows.id}" class = "btn btn-primary mt-5">Edit Show</a>
<a href ="/delete/${shows.id}" class = "btn btn-primary ms-5 mt-5">Delete Show</a>
</c:if>
</div>
</body>
</html>