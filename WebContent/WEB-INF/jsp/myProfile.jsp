<%@page import="by.gsu.epamlab.controllers.ConstantsControllers"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit profile</title>
</head>
<body>
	<hr>
	<h2>Login : ${ keyUser.login }</h2>
	<h2>Name : ${ keyUser.fullName }</h2>
	<h2>Phone : ${ keyUser.phoneNumber }</h2>
	<c:choose>
		<c:when test="${not empty keyUserPlaces }">
			<table border="3" frame="border">
				<caption align="top">
					<br>
					<font size=5 color="blue" face="Times New Roman"> My bought
						tickets :</font> <br>
				</caption>
				<c:forEach items="${ keyUserPlaces }" var="userPlace"
					varStatus="loop">
					<tr>
						<td>&nbsp;&nbsp;${ loop.index + 1 }&nbsp;&nbsp;
						<td>&nbsp;&nbsp;${ userPlace.date }&nbsp;&nbsp;
						<td><c:forEach items="${ keyPlays }" var="userPlay">
								<c:if test="${ userPlace.date ==  userPlay.date}">
									<font size=6 color="black">&nbsp;&nbsp;${ userPlay.name }&nbsp;&nbsp;</font>
								</c:if>
							</c:forEach>
						<td>&nbsp;&nbsp;${ userPlace.number }-${ userPlace.category }&nbsp;&nbsp;

						
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<br>
			<br>
			<br>
			<font size="5" color="blue" face="Times New Roman">You didn't
				book any ticket. Do it now!</font>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<a href=<c:url value="/mainJsp"/>>Main page</a>
	<br>
	<br>
	<jsp:include page="/footerJsp" />
</body>
</html>