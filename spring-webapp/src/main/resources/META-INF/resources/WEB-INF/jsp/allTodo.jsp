<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title> Todo </title>
</head>
<body>
<h1>All todos</h1>

<h2>Welcome user : ${username} </h2>

<p>List of all todos:</p>

<c:forEach items="${todos}" var="todo">
    <p>
            ${todo.getId()}
            ${todo.getName()}
            ${todo.getDescription()}
            ${todo.isFinished()}
    </p>
</c:forEach>
<p>${loginForm}</p>


</body>
</html>


