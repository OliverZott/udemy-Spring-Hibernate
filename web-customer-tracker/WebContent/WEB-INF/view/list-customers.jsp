<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer List</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>


<ul>

    <div id="wrapper">
        <div id="header">
            <h2>CRM - Custom Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">

            <!-- Button to add customer -->
            <input type="button" value="Add Customer"
                   onclick="window.location.href='showFormForAdd'; return false"
                   class="add-button">

            <!-- Table for Output -->
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>E-Mail</th>
                </tr>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <br><br><br>
    Raw Data: <br>
    <c:forEach var="temp" items="${customers}">
        <li> ${temp} </li>
    </c:forEach>
</ul>

</body>
</html>