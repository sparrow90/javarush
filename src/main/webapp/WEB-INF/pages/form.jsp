<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>FORM</title>
</head>
<body>

<form action="/save" method="post"><input type="hidden" name="id" value="${user.id}">
    Name: <input type="text" name="name" value="${user.name}"><br/>
    Age: <input type="number" name="age" min="1" max="100" value="${user.age}"><br/>
    Admin: <input type="checkbox" name="admin" value="true" <c:if test="${user.admin}">checked</c:if> ><br/>
    <input type="submit" value="Save">
</form>

</body>
</html>
