<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lookify</title>
	</head>
	<body>
		<p><a href="songs/new">Add New Song</a></p>
		<p><a href="/search/topTen">Top Songs</a></p>
		<form action="/search" method="POST">
				<input name="artist" type="text"/>
				<button type="submit">Search Artist</button>
		</form>
		
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="song" items="${songs}">
					<tr>
						<td>
							<a href="/songs/${song.id}"><c:out value="${song.title}"/></a>
						</td>
						<td>
							<c:out value="${song.rating}"/>
						</td>
						<td>
							<a href="/songs/remove/${song.id}">Delete</a> |	<a href="/songs/edit/${song.id}">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			
		
		</table>
			
		
	</body>
</html>