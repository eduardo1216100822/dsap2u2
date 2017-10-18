<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Component Form</title>
</head>
<body>
	<form action="ComponentController">
		<label>User:</label>
		<input type="text" name="username" value="${component.username}" /><br /><br />
		<label>InstrumentID:</label>
		<input type="numer" name="instrumentId" value="${component.instrumentId}" /><br /><br />
		<label>ComponentID:</label>
		<input type="number" name="componentId" value="${component.componentId}" /><br /><br />
		<input type="submit" name="btn_save" value="save">
	</form>
</body>
</html>