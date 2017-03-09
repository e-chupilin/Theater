<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add order</title>

<style>
.pointer {
	cursor: pointer;
}
</style>
<script language=JavaScript>
	function sendDeleteForm(date, number, category) {
		if (window.confirm('Delete order ? \n' +'\nDate :' + date 
				+ '\nPlace :  ' + number + '-' + category )) {
		document.getElementById('keyDeleteOrderDate').value = date;	
		document.getElementById('keyDeleteOrderPlaceNumber').value = number;	
		document.getElementById('keyDeleteOrderPlaceCategory').value = category;	
		document.getElementById('deleteOrderForm').submit();
		}					
	}

	function sendAddForm(date, login, number, category) {
		if (window.confirm('Take place in a hall ? \n' +'\nDate :' + date + '\nLogin : ' 
				+ login + '\nPlace :  ' + number + '-' + category )) {
		document.getElementById('keySetOrderPlayDate').value = date;	
		document.getElementById('keySetOrderUserLogin').value = login;	
		document.getElementById('keySetOrderPlaceNumber').value = number;	
		document.getElementById('keySetOrderPlaceCategory').value = category;	
		document.getElementById('addOrderForm').submit();
		}					
	}
	
	function userInfo(login, fullName, phoneNumber) {
		window.alert('Login: ' + login + '\nUser name : '
				+ fullName + '\nPhone number : ' + phoneNumber);
	}
	
	function playInfo(date, name, description, about) {
		window.alert('Date: ' + date + '\nPlay name : '
				+ name + '\nDescription : ' + description + '\nAbout : ' + about);
	}
</script>

</head>
<body>
	<form id='addOrderForm' name="addOrderForm" method="POST" action="<c:url value='/addOrder'/>">
	<input type="hidden" name="keySetOrderPlayDate" id="keySetOrderPlayDate">
	<input type="hidden" name="keySetOrderUserLogin" id="keySetOrderUserLogin">
	<input type="hidden" name="keySetOrderPlaceNumber" id="keySetOrderPlaceNumber">
	<input type="hidden" name="keySetOrderPlaceCategory" id="keySetOrderPlaceCategory">
	</form>
	
	<form id='deleteOrderForm' name="deleteOrderForm" method="POST" action="<c:url value='/deleteOrder'/>">
	<input type="hidden" name="keyDeleteOrderDate" id="keyDeleteOrderDate">
	<input type="hidden" name="keyDeleteOrderPlaceNumber" id="keyDeleteOrderPlaceNumber">
	<input type="hidden" name="keyDeleteOrderPlaceCategory" id="keyDeleteOrderPlaceCategory">
	</form>
		<c:choose>
			<c:when test="${not empty keyOrder }">
				<center>
					<table border="1">
						<caption>
							<br> <font size="5" color="blue" face="Times New Roman">Order
								to confirm:</font> <br>
						</caption>
						<tbody></tbody>
						<c:forEach items="${ keyOrder }" var="order" varStatus="loop">
							<tr>								
								<td>&nbsp;${ loop.index + 1 }&nbsp; 
								<td>&nbsp;${ order.play.date }&nbsp; 
								<td class="pointer" onclick="JavaScript:playInfo('${ order.play.date}', '${ order.play.name}',
									'${ order.play.description}','${ order.play.about}')">&nbsp;${ order.play.name }&nbsp; 
								<td class="pointer"
									onclick="JavaScript:userInfo('${ order.user.login}',
									'${ order.user.fullName}','${ order.user.phoneNumber}')">
									&nbsp;<a>${ order.user.fullName },</a>&nbsp; 
									&nbsp;${ order.user.phoneNumber }, &nbsp; 
								<td>&nbsp;${ order.place.number }-${ order.place.category }&nbsp;
								<td><a onclick="JavaScript:sendAddForm('${ order.play.date }', '${ order.user.login}', 
								'${ order.place.number }', '${ order.place.category }')" href="#">&nbsp;&nbsp;Confirm&nbsp;&nbsp;</a>
								<td><a onclick="JavaScript:sendDeleteForm('${ order.play.date }', '${ order.place.number }', 
								'${ order.place.category }')" href="#">&nbsp;&nbsp;Delete&nbsp;&nbsp;</a>
						</c:forEach>
					</table>
				</center>
			</c:when>
			<c:otherwise>
				<center>
					<font size="5" color="blue" face="Times New Roman">Order list is empty.</font>
				</center>
			</c:otherwise>
		</c:choose>
	<a href="mainJsp">Main page</a>
	<jsp:include page="/footerJsp" />
</body>
</html>