<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

	<head>
	
	</head>
	
	<body>
		<form:form action="processForm" modelAttribute="student">
			
			First Name: 
			<form:input path="firstName" />
			<br><br>
			
			Last Name: 
			<form:input path="lastName" />
			<br><br>
			
			Country: 
			<form:select path="country">
				<form:options path="country" items="${student.countryOptions}"/>
			</form:select>
			<br><br>
			
			Favorite Language:
			<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />
			<br><br>
			
			Operating Systems: 
			Linux <form:checkbox path="operatingSystems" value="Linux"/>			
			Mac OS<form:checkbox path="operatingSystems" value="Mac OS"/>			
			MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>			
			<br><br>
			
			<input type="submit" value="Enviar"/>		
		</form:form>
		<br><br>
		<a href="../">Go Back</a>		
	</body>

</html>