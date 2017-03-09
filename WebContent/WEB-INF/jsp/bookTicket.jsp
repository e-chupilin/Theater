<%@page import="by.gsu.epamlab.model.ConstantsModel"%>
<%@page import="by.gsu.epamlab.model.beans.User"%>
<%@page import="by.gsu.epamlab.controllers.ConstantsControllers"%>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language=javascript src="js/dialog.js"></script>
<script language=JavaScript type="text/javascript">
	function sendForm(number, category) {
		if (window.confirm('${ keyUser.fullName } you want to book tickets ?\n Place : '+ number + ' - ' + category + '.\n Date : ' 
				+ '${ keyUserPlay.date}.\n Play : ${ keyUserPlay.name }\n Phone for contact : ${ keyUser.phoneNumber } ')) {
			window.alert('Thanks!\n Our courier will contact you.');
			document.getElementById('keyPlaceNumber').value = number;	
			document.getElementById('keyPlaceCategory').value = category;	
			document.getElementById('bookTicketForm').submit();
			}			
		}		
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book ticket</title>
</head>
<style>

.free {
	cursor: pointer;
	position: relative;
	width: 60px;
	position: relative;
}

.free p {
	position: absolute;
	left: 40%;
	top: -5%;
	color: white;
}

.busy {	
	cursor: default;
	position: relative;
	width: 60px;
	position: relative;
}

.busy p { 
	position: absolute;
	left: 40%;
	top: -5%;
	color: #484f4f;
}
.scene {
	cursor: pointer;
}
	
</style>
<body>  
	<jsp:include page="/headerJsp" />	
	<h3>Look for free place on play : ${ keyUserPlay.name }</h3>
	<h4> Date of play : ${ keyUserPlay.date }.&nbsp;&nbsp;&nbsp;&nbsp;${ keyUserPlay.about }</h4>
	
	<div style="background-color: grey; color: white;" align="center">	
	<form id='bookTicketForm' name='bookTicketForm' method="POST" action="<c:url value='/ticket'/>">
	<input type=hidden name='keyPlaceNumber' id='keyPlaceNumber' > 	
	<input type=hidden name='keyPlaceCategory' id='keyPlaceCategory' > 	
	<br> 
	<img class="scene" onclick="dialog('<c:url value="/img/place/sceneFoto.jpg"/>', {'title':'Modern stage with good sound.'} )"
			src='<c:url value="/img/place/scene.jpg"/>' alt=""> <br> <br>
	VIP place :
		  <table> <tbody>
				<tr>
					<c:forEach items="${ keyPlace }" var="place"> 
						<c:if test="${ place.category == 'VIP' }">
								<c:if test="${ place.isFree }">
								<td class="free" onclick="JavaScript:sendForm('${ place.number }','${ place.category }')" >
								<img src='<c:url value="/img/place/place_free.jpg"/>'>
								<p>${ place.number }</p>								
								</c:if>
								<c:if test="${ not place.isFree }">
								<td class="busy">								
								<img src='<c:url value="/img/place/place_not_free.jpg"/>'>
								<p>${ place.number }</p>								
								</c:if>														
						</c:if>						
					</c:forEach>				
		</tbody></table>

		<br> Porterre place :
		<table> <tbody>  				
				<tr> <c:set var="placeInRow" scope="page" value="<%=ConstantsModel.PARTERRE_ROW_PLACES_QUANTITY %>"/>
					<c:forEach items="${ keyPlace }" var="place">
						<c:if test="${ place.category == 'PARTERRE' }">							
								<c:if test="${ place.isFree }">
								<td class="free" onclick="JavaScript:sendForm('${ place.number }','${ place.category }')" >
								<img src='<c:url value="/img/place/place_free.jpg"/>'>
								<p>${ place.number }</p>								
								</c:if>
								<c:if test="${ not place.isFree }">
								<td class="busy">
								<img src='<c:url value="/img/place/place_not_free.jpg"/>'>
								<p>${ place.number }</p>								
								</c:if>																												
							<c:if test="${ place.number == placeInRow }">
							<c:set var="placeInRow" scope="page" value="${ placeInRow + placeInRow }"/>
							<tr>
							</c:if>
						</c:if>												
					</c:forEach>				
		</tbody></table>
		<br>
		<br> Balcony place :
		<table><tbody>
				<tr>
					<c:forEach items="${ keyPlace }" var="place">
						<c:if test="${ place.category == 'BALCONY' }">
							<td>							
								<c:if test="${ place.isFree }">
								<td class="free" onclick="JavaScript:sendForm('${ place.number }','${ place.category }')">
								<img src='<c:url value="/img/place/place_free.jpg"/>'>
								<p>${ place.number }</p>								
								</c:if>
								<c:if test="${ not place.isFree }">
								<td class="busy">
								<img src='<c:url value="/img/place/place_not_free.jpg"/>'>
								<p>${ place.number }</p>								
								</c:if>														
						</c:if>						
					</c:forEach>			
		</tbody></table>
		<br><br>
	</form>
	</div>
	<a href="mainJsp">Main page</a>
	<br><br>	
	<jsp:include page="/footerJsp" />
</body>
</html>