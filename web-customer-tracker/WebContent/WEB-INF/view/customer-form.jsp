<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Save Customer</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Customer</h3>


    <!--
    When customer-form is LOADED by "showFormForAdd" or "saveCustomer",
    spring will call getters of customer-entity

    On SUBMIT Spring will load setters and on submit will call saveCustomer Method to persist!
    -->
    <form:form action="saveCustomer" modelAttribute="customer" method="POST">

        <!-- to use given ID in case of "update", need hidden field to assign id -->
        <form:hidden path="id"/>

        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName"/></td>
                <td><form:errors path="firstName"/></td>
            </tr>
            showFormForAdd
            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName"/></td>
                <td><form:errors path="lastName"/></td>
            </tr>
            <tr>
                <td><label>E-Mail:</label></td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>

    <!--
    <div>${pageContext.request.contextPath}</div>
    -->

    <p>
        <a href="${pageContext.request.contextPath}">Back to customer list</a>
    </p>
</div>

</body>
</html>
