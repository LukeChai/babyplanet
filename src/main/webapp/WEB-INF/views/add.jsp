<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false"%>
<html>
<head>
<title>Add Customer</title>
</head>
<body>
	<form:form method="POST" modelAttribute="customer">
		<form:input type="hidden" path="id" id="id" />
		<table>
			<tr>
				<td><label for="name">Name:</label></td>
				<td><form:input path="name" id="name" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
