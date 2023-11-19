<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search ad</title>
</head>
<body>
<form method="post" action="/searchAd">
    <h2>Input number ad</h2><input name="id">
    <br/>
    <button type="submit">Go</button>
</form>
<a href="<c:url value="/bulletinBoard"/>">Return to back</a>
</body>
</html>
