<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>

	<!-- display user name and role -->

	<p>
		User: <security:authentication property="principal.username"/>
		<br> <br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>

	<security:authorize access="hasRole('MANAGER')">
		<hr>
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for manager people)
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<hr>
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(Only for Admin people)
		</p>
	</security:authorize>
	<hr>

	Welcome to the luv2code company home page - new world!
	<form:form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Logout"/>
	</form:form>
</body>

</html>
