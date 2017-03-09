<%@page import="by.gsu.epamlab.controllers.ConstantsControllers"%>
<%@page import="java.sql.Date"%>
<%@page import="by.gsu.epamlab.utilities.ServletUtilities"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plays</title>

<style>
.pointer {
	cursor: pointer;
}
</style>

</head>
<script language=JavaScript src="js/dialog.js"></script>

<script language=JavaScript>
function sendForm(keyPlayDate) {	
	document.getElementById('keyPlayDate').value=keyPlayDate;	
	document.getElementById('viewPlaysForm').submit();
}
</script>

<body> 
<jsp:include page="/headerJsp" />
 <form id='viewPlaysForm' name="viewPlaysForm" method="POST" action="<c:url value='/loadPlaces'/>">
	
	<c:choose>
		<c:when test="${empty keyPlaysErrorMessage }">
			<center>
				<table border="1">
					<caption align="top">
						<br> <font size=5 color="blue" face="Times New Roman">REPERTOIRE
							: </font> <br>
					</caption>
					<tbody></tbody>
					<c:forEach items="${ keyPlays }" var="play" varStatus="loop">
						<tr>
							<c:if test="${not empty keyUser}">
								<td>					
										<font size=4>
										<input type=hidden name='keyPlayDate' id='keyPlayDate'>
										<a onclick="JavaScript:sendForm('${ play.date }')" href="#">${play.date}</a>										
										</font>									
							</c:if>
							<td align="center" class="pointer" onclick="dialog('<c:url value="/img/${ play.pictureFileName }"/>', {'title':'${ play.description }'} )">
							<font size=10>
							&nbsp;&nbsp;${ play.name }&nbsp;&nbsp;
							</font>
							<td>
							<font size=2>${ play.about }</font>
						<tr>
					</c:forEach>
					</tbody>
				</table>
			</center>
		</c:when>
		<c:otherwise>
			<center>
				<h2>
					<font color="red"> ${ keyPlaysErrorMessage }</font>
				</h2>
			</center>
		</c:otherwise>
	</c:choose>
	<a href="mainJsp">Main page</a>
	<br>
	<br>	
</form>	
<jsp:include page="/footerJsp" />
</body>
</html>