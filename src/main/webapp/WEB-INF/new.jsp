<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add Song</title>
	</head>
	<body>
	<p><a href="/dashboard">Dashboard</a></p>
	
	<form:form action="/songs/new" method="post" modelAttribute="song">
		<p>
			<form:label path="title">Title</form:label>
			<form:input path="title"/>
			<form:errors path="title"/>
		</p>
		<p>
			<form:label path="artist">Artist</form:label>
			<form:input path="artist"/>
			<form:errors path="artist"/>
		</p>
		<p>
			<form:label path="rating">Rating</form:label>
			<form:input path="rating" type="number"/>
			<form:errors path="rating" />
		</p>
		<input type="submit" value="Add Song"/>
	</form:form>
		
	</body>
</html>