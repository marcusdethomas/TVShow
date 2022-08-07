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
<title>Dashboard</title>
</head>
<body>
<div>
<div class = "container col-7">
<div class = "d-flex justify-content-evenly mt-4">
<a href = "/create">Add a Show	</a>
<a href = "/logout">Log Out</a>
</div>
	<table class="table table-striped table-bordered table-hover mt-5">
	  <h1> Welcome, <c:out value="${userId.name}"></c:out></h1>
	  <thead>
        <tr>
            <th>Title</th>
            <th>Network</th>
            <th>Posted By</th>
        </tr>
    </thead>
		<tbody>
			<c:forEach var="show" items="${shows}">
				<tr>
					<td>
				<a href = "shows/${show.id}"><c:out value="${show.title}"></c:out></a>
				</td>
				<td>
				<c:out value="${show.network}"></c:out>
				</td>
				<td>
				<c:out value="${show.user.name}"></c:out>
				</td>
				</tr>	
			</c:forEach>
    	</tbody>
    </table>
</div>
</div>
</body>
</html>