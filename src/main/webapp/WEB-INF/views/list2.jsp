<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false"%>

<table>
	<tr>
		<td>Name:</td>
	</tr>
	<c:forEach items="${customers}" var="customer">
		<tr>
			<td>${customer.name}</td>
		</tr>
	</c:forEach>
</table>
