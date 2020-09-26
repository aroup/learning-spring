<%--
  Created by IntelliJ IDEA.
  User: goldie
  Date: 8/6/20
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First Name: <form:input path="firstName"/>
    <br/><br/>
    Last Name: <form:input path="lastName"/>
    <br/><br/>
    Country: <form:select path="country">
        <form:options items="${student.countryOptions}"/>
    </form:select>
    <br/> <br/>
    Favorite Language:
    <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>

    <br/><br/>

    Operating systems:
    Linux <form:checkbox path="operatingSystems" value="Linux"/>
    Mac <form:checkbox path="operatingSystems" value="Mac"/>
    Windows <form:checkbox path="operatingSystems" value="Windows"/>
    <input type="submit" value="Submit"/>

</form:form>
</body>
</html>
