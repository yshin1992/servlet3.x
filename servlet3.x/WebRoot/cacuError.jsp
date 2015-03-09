<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计算器异常错误提示页面</title>
</head>
<body>
<h1>出现异常:</h1>
<% out.println(exception.getMessage(  ) );%>
<h4>详细错误</h4>
<% out.println(exception.getStackTrace(  )); %>
</body>
</html>