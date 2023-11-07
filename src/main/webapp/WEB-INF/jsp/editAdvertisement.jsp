<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit advertisement</title>
</head>
<body>
<form method="post" action="/edit">
    <div>
        <h2>Edit ad</h2>
    </div>
    <div>
        <p>Input id ad</p>
        <input type="number" name="id">
        <br/>
        <button type="submit">Go</button>
    </div>
    <a href="/bulletinBoard">Return to back</a>
</form>

</body>
</html>
