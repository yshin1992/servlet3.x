<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
以下是caculator.jsp的内容：<br/>
	<%
		//将caculator页面include到本页面上来
		request.getRequestDispatcher( "caculator.jsp" ).include( request, response );
		//跳转到caculator.jsp去
		//request.getRequestDispatcher( "caculator.jsp" ).forward( request, response );
	%>
</body>
</html>