<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="ISO-8859-1">

    <title>Customer Registration Form</title>

    <style type="text/css">
        .error1 {
            color: red;
        }
    </style>

</head>
<body>


<div>

    Fill out the form (*) is required)
    <br> <br>

    <form:form action="processCustomerForm" modelAttribute="customerAttr">
        First Name: <form:input path="firstName"/>
        <br> <br>
        Last Name (*): <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error1"/>
        <br> <br>

        Free passes: <form:input path="freePasses"/>
        <form:errors path="freePasses" cssClass="error1"/>
        <br><br>

        Postal code <form:input path="postalCode"/>
        <form:errors path="postalCode" cssClass="error1"/>
        <br><br>

        Course Code: <form:input path="courseCode"/>
        <form:errors path="courseCode" cssClass="error1"/>
        <br><br>

        <input type="submit" value="Submit!">

    </form:form>
</div>


</body>
</html>