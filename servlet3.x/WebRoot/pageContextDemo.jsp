<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PageContext 对象</title>
</head>
<body>
	<%
		pageContext.setAttribute( "username", "yshin1992" );//默认范围：request
		pageContext.setAttribute( "password", "1992", pageContext.PAGE_SCOPE );
		pageContext.setAttribute( "age", "23", pageContext.SESSION_SCOPE );
		pageContext.setAttribute( "gender", "male", pageContext.APPLICATION_SCOPE );
	%>

	<%
		out.println( pageContext.getAttribute( "username" ) +"变量所在范围"+pageContext.getAttributesScope( "username" )+ "<br/>" );
		out.println( pageContext.getAttribute( "password" )  +"变量所在范围"+pageContext.getAttributesScope( "password" )+ "<br/>" );
		out.println( pageContext.getAttribute( "age" ) +"变量所在范围"+pageContext.getAttributesScope( "age" ) + "<br/>" );
		out.println( pageContext.getAttribute( "gender" )  +"变量所在范围"+pageContext.getAttributesScope( "gender" )+ "<br/>" );
	%>
</body>
</html>