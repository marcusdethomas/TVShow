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
<title>Insert title here</title>
</head>
<body>

<div class = "container">
<div class = "d-flex justify-content-evenly mt-4">
<a href ="/dashboard">Return Home</a>
<a href = "/create">Add a Show</a>
<a href = "/logout">Log Out</a>
</div>
<div class = "justify-content-evenly mt-4">
<form:form action="/create"  method="post" modelAttribute="shows">
	<div class="form-group">
				<form:label path="title">Title</form:label>
				<form:errors path="title" class="error text-danger"/>
				<form:input path="title" type="text" class="form-control"/>		
				
				<form:label path="network">Network</form:label>
				<form:errors path="network" class="error text-danger"/>
				<form:input path="network" type="text" class="form-control"/>		
				
				<form:label path="description">Description:</form:label>
				<form:errors path="description" class="error text-danger"/>
				<form:textarea path="description"  rows="5" class="form-control"/>	
			
				<form:errors path="user" class="error text-danger"/>
				<form:input path="user.id" type="hidden" value="${userId.id}" class="form-control"/>	
		
				</div>
	</div>
  		<div class ="d-flex justify-content-center mt-4">
  		<button type="submit" class="btn btn-primary">Submit</button>
  	</div>
</form:form>
</div>
</html>