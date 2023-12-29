<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<header>
  <h1>Servlet / JSP</h1>
  <p>Dept Practice Header</p>
  <div align="right">
	  	<c:if test="">
		  	<span style="font-size:12pt;"><input type="button" value="로그인" onclick="location.href=''"></span>
	  	</c:if>
  		<c:if test="">
  			<span> 님 </span>
	  		<span style="font-size:12pt;"><input type="button" value="로그아웃" onclick="location.href=''"></span>
		</c:if>
	</div>
</header>
