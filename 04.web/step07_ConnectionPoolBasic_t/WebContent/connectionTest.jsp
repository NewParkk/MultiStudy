<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.DBUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ConnectionTest</title>
</head>
<body>
	<h3>DBUtil.getConnection()</h3>
	<%
		out.println(DBUtil.getConnection());
	%>
	
</body>
</html>