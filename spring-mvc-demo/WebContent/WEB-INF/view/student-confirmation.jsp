<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation Form</title>
</head>
<body>
	<div>
	This student is confirmed: ${student.firstName} ${student.lastName}
	<br> <br>
	Country: ${student.country}
	<br> <br>
	Favorite Language: ${student.favoriteLanguage}
	<br> <br>
	Operating Systems:   <!-- ${student.operatingSystems}  -->
	
		<ul>
			<c:forEach var="temp" items="${student.operatingSystems}" > 
			<li> ${temp} </li>
			</c:forEach>
		</ul>
		
	<br> <br>
	</div>

	<hr>
	
	<!-- <a href="/spring-mvc-demo/">Back to main-menu</a>  -->
	<a href="${ pageContext.request.contextPath }">Back to home</a>
</body>
</html>