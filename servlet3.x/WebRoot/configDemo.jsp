<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Config(SerlvetConfig)实例</title>
</head>
<body>
<h4><%=config.getServletName(  ) %></h4>

driver:<%=config.getInitParameter( "driver" ) %>
</body>
</html>