<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

            <!-- Search form for first/last name -->
            <form:form action="search" method="GET">Search Customer:
                <input type="text" name="theSearchName"/>
                <input type="submit" value="Search" class="add-button">
            </form:form>

            <!-- Table for Output -->
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>E-Mail</th>
                    <th>Action</th>
                </tr>
                <!-- loop over and print customers -->
                <c:forEach var="customer" items="${customers}">

                    <!-- construct an "update"-link with customer id -->
                    <c:url var="updateLink" value="/customer/delete">
                        <c:param name="customerId" value="${customer.id}"/>
                    </c:url>

                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${customer.id}"/>
                    </c:url>
                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure to delete?'))) return false">Delete</a>
                        </td>
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