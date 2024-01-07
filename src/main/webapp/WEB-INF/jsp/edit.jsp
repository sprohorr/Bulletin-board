<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/editAdvertisement" method="post">
    <input type="hidden" name="id" value="${id}">
    <p>Service name</p><input name="serviceName">
    <p>Description</p><input name="description">
    <p>Price</p><input name="price">
    <p>Contractor's name</p><input name="contractorName">
    <p>Phone number</p><input name="phoneNumber">
    <button type="submit">Edit</button>
</form>
<a href="/bulletinBoard">Return to back</a>
</body>
</html>
