<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feedback</title>
</head>
<body>
<form method="post">
    <p>Number ad</p><input name="adId">
    <p>User name</p><input name="userName">
    <p>description</p><input name="description">
    <p>grade 1-5</p><input name="grade">
    <br/>
    <button type="submit">Submit</button>
    <br/>
</form>
<a href="bulletinBoard.jsp">Return to back</a>

</body>
</html>
