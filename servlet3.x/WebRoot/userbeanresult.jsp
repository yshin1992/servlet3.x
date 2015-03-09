<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Jsp UseBean 结果</title>
	</head>
	<body>
		<jsp:useBean id="user" class="com.bean.User" scope="page">
			<jsp:setProperty name="user" property="*" />

			<h1>
				用户信息
			</h1>
			<jsp:getProperty name="user" property="name" /><br />
			<jsp:getProperty name="user" property="age" /><br />
		</jsp:useBean>
	</body>
</html>