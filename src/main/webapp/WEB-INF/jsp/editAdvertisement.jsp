<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit advertisement</title>
</head>
<body>
<form method="get" action="/edit">
    <div>
        <h2>Edit ad</h2>
    </div>
    <div>
        <p>Input id ad</p>
        <input name="id">
        <br/>
        <button type="submit">Go</button>
    </div>
</form>
<a href="/bulletinBoard">Return to back</a>
</body>
</html>
