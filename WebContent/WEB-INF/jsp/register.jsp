<%@page import="by.gsu.epamlab.controllers.ConstantsControllers"%>
<%@page import="by.gsu.epamlab.model.beans.User"%>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register new user</title>
</head>
<body>

	<form name="registerForm" method="POST" action="<c:url value='/register' />">
		<center>
			<h2>For registration fill a form:</h2>

			<c:if test="${ empty keyUser }">
				<table>
					<tr>
						<td><label for="login">Login</label></td>
						<td><input type="text" name="keyRegisterLogin" id="login" /></td>
					</tr>
					<tr>
						<td><label for="fullname">Full name</label></td>
						<td><input type="text" name="keyRegisterFullName" id="fullname" /></td>
					</tr>

					<tr>
						<td><label for="phone">Phone number</label></td>
						<td><input type="text" name="keyRegisterPhoneNumber"
							id="phone" /></td>
					</tr>

					<tr>
						<td><label for="pass">Password</label></td>
						<td><input type="password" name="keyRegisterPassword"
							id="pass" /></td>
					</tr>
					<tr>
						<td><label for="confpass">Repeat password</label></td>
						<td><input type="password" name="keyRegisterPasswordRepeat"
							id="confpass" /></td>
					</tr>
				</table>
				<br>
				<c:if test="${not empty keyErrorMessage }">
					<font color="red"> ${ keyErrorMessage } &nbsp;&nbsp; </font>
				</c:if>
				<br>


				<a href="JavaScript:document.registerForm.submit()">Create new
					user</a>
			</c:if>

			<c:if test="${not empty keyUser }">
				<a href=<c:url value="/mainJsp"/>>Registration is complete! </a>
			</c:if>

		</center>
		<br> <br> <br> <a href=<c:url value="/mainJsp"/>>Main page</a> <br>
		<br>
	</form>
	<jsp:include page="/footerJsp" />
</body>
</html>