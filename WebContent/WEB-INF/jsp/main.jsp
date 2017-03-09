<%@page import="by.gsu.epamlab.controllers.ConstantsControllers"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Bigger Theater main page.</title>
</head>
<body>
	<jsp:include page="/headerJsp" />
	<div align="left">
		<c:choose>
			<c:when test="${not empty keyUser }">
				<a href=<c:url value="/play"/>><big>Look at plays and buy ticket</big></a>
				<br>
			</c:when>
			<c:otherwise>
				<a href=<c:url value="/play"/>><big>Look at plays</big></a>
				<br>
				To buy ticket please register!
			</c:otherwise>
		</c:choose>
	</div>
	<br>
	<center>
		<h1>The Bigger Theater.</h1>
	</center>
	<big>You can examine repertoire and look at existence of empty
		seats in a hall. You can be registered and buy the ticket online. At
		registration our courier will contact you.</big>
	<h2>You are welcome !</h2>
	<br>
	<br>
	<jsp:include page="/footerJsp" />
</body>
</html>