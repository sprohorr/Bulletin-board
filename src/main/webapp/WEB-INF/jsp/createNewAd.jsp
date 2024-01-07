<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create a new advertisement</title>
</head>
<body>
<form method="post" action="/create">
    <p>Service name</p><input type="text" name="serviceName">
    <p>Description</p><input type="text" name="description">
    <p>Price</p><input type="text" name="price">
    <p>Contractor's name</p><input type="text" name="contractorName">
    <p>Phone number</p><input type="text" name="phoneNumber">
    <button type="submit">Create</button>
</form>
<a href="/bulletinBoard">Return to back</a>
</body>
</html>
