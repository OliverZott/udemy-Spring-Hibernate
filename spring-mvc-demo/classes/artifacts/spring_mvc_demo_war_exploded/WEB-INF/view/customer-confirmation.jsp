<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Customer Confirmation</title>
</head>
<body>

Confirmed Customer: ${customerAttr.firstName} ${customerAttr.lastName}
<br><br>
Free passes: ${customerAttr.freePasses}
<br><br>
Postal code: ${customerAttr.postalCode}

<br><br>
Course code:${customerAttr.courseCode}

</body>

</html>



