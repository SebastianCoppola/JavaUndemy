<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
	<body>
		<h2>
			Hello ${student.firstName} ${student.lastName}!
		</h2>
		<p>Country: ${student.country}</p>			
		<p>Favorite Language: ${student.favoriteLanguage}</p>	
		<p>Operating Systems: 
		<ul>
			<c:forEach var="temp" items="${student.operatingSystems}">
			<li> ${temp} </li>
			</c:forEach>
		</ul>
		
				
		<a href="../">Go Back</a>
	</body>
</html>