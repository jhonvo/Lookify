<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Search</title>
	</head>
	<body>
		<h1>Top Ten songs</h1>
		<p><a href="/dashboard">Dashboard</a></p>
		<table>
			<thead>
				<tr>
					<th>Rating</th>
					<th>Name</th>
					<th>Artist</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="song" items="${songs}">
					<tr>
						<td>
							<c:out value="${song.rating}"/>
						</td>
						<td>
							<a href="/songs/${song.id}"><c:out value="${song.title}"/></a>
						</td>
						
						<td>
							<c:out value="${song.artist}"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
	</body>
</html>