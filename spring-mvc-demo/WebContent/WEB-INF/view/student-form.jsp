<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<body>

	<form:form action="processForm" modelAttribute="student">
	
	First Name : <form:input path="firstName" />

	<br>
	<br>
	Last Name : <form:input path="lastName" />
	
	<br>
	<br>	
	Country : 
	<form:select path="country">
			<form:options items="${student.countryOptions}" />
	</form:select>

	<br><br>	
	Java <form:radiobutton path="favoriteLanguage" value="Java" />
	C# <form:radiobutton path="favoriteLanguage" value="C#" />
	PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
	Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />

	<br><br>
	operating Systems :
		
	Windows <form:checkbox path="operatingSystems" value="Windows" />
	Mac <form:checkbox path="operatingSystems" value="Mac" />
	Linux <form:checkbox path="operatingSystems" value="Linux" />>

	<input type="submit" value="Submit" />

	</form:form>




</body>
</head>
</html>