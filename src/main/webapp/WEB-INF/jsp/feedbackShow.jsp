<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show</title>
</head>
<body>
<table>
    <c:forEach var="list" items="${feedbacks}">
        <tr>
            <td>${list.id}</td>
            <td>${list.userName}</td>
            <td>${list.description}</td>
            <td>${list.grade}</td>
            <td>${list.adId}</td>
        </tr>
        <br/>
    </c:forEach>
</table>
<br/>
<a href="/bulletinBoard">Return to back</a>
</body>
</html>
