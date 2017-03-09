<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit plays page</title>

<style>
.but {
	font-weight: bold;
}
.titleTab {
	color: blue;
	font-weight: bold;
	font-size: x-large;
}
</style>

</head>
<script>
	function checkInput() {
	}
</script>
<body>
	<hr>
	<center>
		<form action=<c:url value="/addPlay"/> method="post">
			<table cellpadding="5" frame="border">
				<caption align="top">
					<span class="titleTab">New play :</span>
				</caption>					
				<tr>
					<td>Date of play : <td><input size="3" maxlength="4" name="keyAddYear" id="keyAddYear" />
					-
					<input size="1" maxlength="2" name="keyAddMounth" id="keyMounth" />
						<script language=JavaScript type="text/javascript">
							var today = new Date();
							document.getElementById("keyYear").value = today.getFullYear();
							document.getElementById("keyMounth").value = today.getMonth();
						</script>
				-
				<input size="1" maxlength="2" name="keyAddDay" id="keyAddDay" />			
				<tr>
				<td> Name :
				<td><input size="50" name="keyAddPlayName" id="keyAddPlayName" />
				<tr>
				<td> Description :
				<td><input size="50" name="keyAddPlayDescription" id="keyAddPlayDescription" />
				<tr>
				<td> About :
				<td><input value="Producer:  By:" size="50" name="keyAddPlayAbout"	id="keyAddPlayAbout" />
				<tr>
				<td> Poster (image) :
				<td><input type="file" name="keyAddPlayPicture" id="keyAddPlayPicture" />
				<tr>
				<td>
				<td align="right">
				<input class="but" type="submit" value="Add play">		
			</table>
		</form>
		<br><br>
		<form action=<c:url value="/deletePlay"/> method="post">
			<table cellpadding="5" frame="border">
				<caption>
					<span class="titleTab">Play to delete :</span>
				</caption>	
			<tr>
					<td>		
			<select size="7" multiple name="keyDeletePlayDate">
				<c:forEach items="${ keyPlays }" var="play">
					<option value="${ play.date }">&nbsp;&nbsp;${ play.date }&nbsp;,&nbsp;
						${ play.name }&nbsp;&nbsp;</option>
				</c:forEach>
			</select>			
				<tr>
				<td align="right">
				<input class="but" type="submit" value="Delete">
			</table> 
		</form>
		<br> <br> <br>
		</center>
	<a href="mainJsp">Main page</a>
	<br>
	<br>
	<jsp:include page="/footerJsp" />
</body>
</html>