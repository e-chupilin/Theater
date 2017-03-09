<%@page import="by.gsu.epamlab.controllers.ConstantsControllers"%>
<%@page import="by.gsu.epamlab.model.beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<hr>
	&nbsp;&nbsp; User :
	<c:choose>
		<c:when test="${not empty keyUser }">
			${keyUser.login} &nbsp; (${keyUser.fullName})
			<div align="right">
				<c:if test="${ keyUser.login == 'admin' }">
				<a href="#">Administrator work page </a> 
				&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<c:if test="${ keyUser.login == 'courier' }">
				<a href=<c:url value="/editPlay"/>>Edit plays </a> 
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href=<c:url value="/addOrderJsp"/>>User`s orders </a> 
				&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>			
					<a href=<c:url value="/myProfile"/>>My profile</a>
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<a href="<c:url value='/logout'/>">Exit</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</c:when>
		<c:otherwise>
	guest				
			<div align="right">
				<form id="loginForm" name="loginForm" method="POST"
					action="<c:url value='/login' />">
					<input type="text" name="keyLogin" value="courier"> <input
						type="password" name="keyPassword" value="1234">
					&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="JavaScript:document.loginForm.submit();">Login</a>
					&nbsp;&nbsp;&nbsp; <a href=<c:url value="/registerJsp"/>>Register</a>
					&nbsp;&nbsp;&nbsp;
				</form>
			</div>
		</c:otherwise>
	</c:choose>
	<c:if test="${not empty keyErrorMessage }">
		<div align="center">
			<font size=4 color="red"> ${ keyErrorMessage } </font>
		</div>
	</c:if>

	<hr>
</body>
</html>