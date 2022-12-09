<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Courses</title>
</head>
<body>
<h2>All Courses</h2>
<form>

    <c:forEach items="${courses}" var="course">
        <p>
            crs:
                ${course}
        </p>
        <input type="checkbox" name="enrolled" value="${course.isRegistered()}"/>
    </c:forEach>
    <button type="submit">submit</button>
</form>

</body>
</html>