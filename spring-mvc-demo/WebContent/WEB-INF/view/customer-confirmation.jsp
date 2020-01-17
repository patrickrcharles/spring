<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Customer Confirmation </title>
</head>

<body>
	The Customer is confirmed: ${customer.firstName}  ${customer.lastName}
	<br><br>
	free passes : ${customer.freePasses}
	<br><br>
	postal code : ${customer.postalCode}
	<br><br>
	course code : ${customer.courseCode}
</body>
</html>