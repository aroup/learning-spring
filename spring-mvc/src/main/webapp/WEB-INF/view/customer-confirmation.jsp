<%--
  Created by IntelliJ IDEA.
  User: goldie
  Date: 8/7/20
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
The customer is confirmed: ${customer.firstName} ${customer.lastName}
<br/>
<br/>
Free passes: ${customer.freePasses}
<br/>
<br/>
Postal code: ${customer.postalCode}
<br/>
<br/>
Course Code: ${customer.courseCode}
</body>
</html>
