<%--
  Created by IntelliJ IDEA.
  User: goldie
  Date: 9/19/20
  Time: 6:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Plain Login</title>
    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>
    <h3>My Custom Login Page</h3>
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
        <c:if test="${param.error != null}">
            <i class="failed">Sorry! You have entered invalid username/password.</i>
        </c:if>
        <p>
            User name: <input type="text" name="username"/>
        </p>
        <p>
            Password: <input type="password" name="password"/>
        </p>
        <input type="submit" value="Login"/>
    </form:form>

</body>
</html>
