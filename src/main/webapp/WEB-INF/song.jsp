<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Details</title>
	</head>
	<body>
		<h1><c:out value="${song.title}"/></h1>
		<p><a href="/dashboard">Dashboard</a></p>
		<p>Artist: <c:out value="${song.artist}"/></p>
		<p>Rating: <c:out value="${song.rating}"/></p>
		<a href="/songs/remove/${song.id}">Delete</a>
		<a href="/songs/edit/${song.id}">Edit</a>
	</body>
</html>