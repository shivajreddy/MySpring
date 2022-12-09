<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Courses</title>
</head>
<body>
<h2>All Courses</h2>
<c:forEach items="${courses}" var="course">
    <p>
        crs:
            ${course}
    </p>
</c:forEach>

</body>
</html>