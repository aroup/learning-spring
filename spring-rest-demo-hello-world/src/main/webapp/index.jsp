<%--
  Created by IntelliJ IDEA.
  User: goldie
  Date: 9/22/20
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Rest Demo</title>
</head>
<body>
    Spring Rest Demo
    <a href="${pageContext.request.contextPath}/test/hello">Hello</a>

    <a href="${pageContext.request.contextPath}/api/students">Get All Students</a>
</body>
</html>
