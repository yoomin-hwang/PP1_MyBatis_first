<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

<h1>Edit Post</h1>
<form:form modelAttribute="u" method="POST" action="../editok">
	<form:hidden path="seq"/>
	<table id="edit">
		<tr><td>Title:</td><td><form:input type="text" path="title"/></td></tr>
		<tr><td>Writer:</td><td><form:input type="text" path="writer"/></td></tr>
		<tr><td>Content:</td><td><form:textarea name="content" cols="50" rows="5" path="content"/></td></tr>
		<tr><td><a href="list.jsp">View All Records</a></td><td align="right"><input type="submit" value="Edit Post"/></td></tr>
	</table>
</form:form>

</body>
</html>