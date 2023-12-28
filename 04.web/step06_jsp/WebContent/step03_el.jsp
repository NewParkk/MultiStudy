<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, user.dto.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step03_el</title>
</head>
<body>
	<h3>step03_EL</h3>
	
	<h4>배열</h4>
	<% 
		String[] strs = {"a", "b", "c"};	
		request.setAttribute("strs", strs);
		out.println(strs[1]);
	%>
	<%= strs[1] %> <br/>
	${requestScope.strs[1]}<br/>
	
	<h4>ArrayList</h4>
	<%
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		session.setAttribute("strList", strList);
	%>

	${sessionScope.strList.get(1)}<br/>
	<hr/>
	<c:forEach items="${sessionScope.strList}" var="str" varStatus="loop">
		<div>${loop.count}번 데이터 : ${str}</div>
	</c:forEach>
	

	<h4>DTO</h4>
	<%
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User("IT", 28));
		users.add(new User("Dev", 30));
		session.setAttribute("users", users);
	%>

	${sessionScope.users.get(1).getName()}
	${sessionScope.users.get(1).getAge()}

	<c:forEach items="${sessionScope.users}" var="user" varStatus="loop">
		<div>${loop.count}번 데이터 - 이름 : ${user.getName()} 나이 : ${user.getAge()}</div>
	</c:forEach>







</body>
</html>