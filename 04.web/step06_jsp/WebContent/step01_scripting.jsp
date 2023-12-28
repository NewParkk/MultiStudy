<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step01_scripting</title>
</head>
<body>
<%-- JSP 주석 --%>
<%! String name = "dev"; %>

1. <%= name %> <br/>
2. <% out.println(name); %> <br/>
<% int age = 28; %>
3. <%= age %> <br/>

<hr/>
1. 2 + 3 = ${ 2 + 3 } <br/>
2. 2 > 3 = %{ 2 > 3 } <br/>
3. 'a' == 'a' = ${'a' == 'a'} <br/>
<% 
//  Scope : 범위
	
	
	
	
	//
	pageContext.setAttribute("pageData", "현재 페이지에서만 사용 가능");
	request.setAttribute("reqData", "요청 객체 데이터");
	session.setAttribute("sessionData", "세션 객체 데이터");
	
%>
4. pageContext - data : ${pageScope.pageData} <br/>
5. request  - data : ${requestScope.reqData} <br/>
6. session - data : ${sessionScope.sessionData} <br/>




</body>
</html>