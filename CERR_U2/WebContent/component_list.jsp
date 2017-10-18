<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Component List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
				<form action="ComponentController">
					<input type="submit" name="btn_new" value="New">
				</form>
			</th>
			<th>Id</th>
			<th>User</th>
			<th>InstrumentID</th>
			<th>ComponentId</th>
		</tr>
			<c:forEach var="component" items="${components}">
				<tr>
					<td>
						<form action="ComponentController">
							<input type="hidden" name="compId" value="${component.compId}">
							<input type="submit" name="btn_edit" value="Edit">
							<input type="submit" name="btn_delete" value="Delete">
						</form>
					</td>
					<td>${component.compId}</td>
					<td>${component.username}</td>
					<td>${component.instrumentId}</td>
					<td>${component.componentId}</td>	
				</tr>
			</c:forEach>
	</table>
</body>
</html>