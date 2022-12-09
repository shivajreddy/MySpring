<%--<%taglib uri="http://" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title> Todo </title>
</head>
<body>
<h1>All todos</h1>

<h2>Welcome user : ${username} </h2>

<c:forEach items="${todos}" var="todo">
    <p>
            ${todo}
    </p>
</c:forEach>
<p>${loginForm}</p>

My first html page with body - JSP
</body>
</html>