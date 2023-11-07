<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advertisement</title>
</head>
<body>
<c:out value="Id:  ${ad.id}"></c:out><br/>
<c:out value="Service name:  ${ad.serviceName}"></c:out><br/>
<c:out value="Description:  ${ad.description}"></c:out><br/>
<c:out value="Price:  ${ad.price}"></c:out><br/>
<c:out value="Contractor's name:  ${ad.contactorName}"></c:out><br/>
<c:out value="Phone number:  ${ad.phoneNumber}"></c:out><br/>
<c:out value="Average rating:  ${ad.average}"></c:out><br/>
<br/>
<a href="/feedback">Feedback</a>
<a href="/bulletinBoard">Return to back</a>

</body>
</html>
