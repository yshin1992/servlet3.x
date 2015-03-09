<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://www.mysite.org/mytablib" prefix="pe"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'taglibdemo.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<h3>
			第一个实例
		</h3>
		<br>
		<pe:helloWorld />
		.
		<br>
		<h3>
			带有属性的Tag实例:
		</h3>
		<br />
		<pe:queryCityList driver="com.mysql.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/test" user="root" pswd=""
			sql="select * from cities where parentCode=0" />
		<h3>
			带有标签体的实例:
		</h3>
		<br />
		<%
			List<String> a = new ArrayList<String>();
			a.add("疯狂java");
			a.add("www.crazyit.org");
			a.add("java");
			pageContext.setAttribute("list", a);
		%>
		<table border="1" bgcolor="#aaaadd" width=200>
			<pe:iterator collection="list" item="item">
				<tr>
					<td>
						${pageScope.item }
					</td>
				</tr>
			</pe:iterator>
		</table>
		
		<h3>
			下面显示的是自定义标签体中的内容(注意：在最新版本的Tomcat中，在以下代码加入注释的话会提示:
			According to TLD, tag mytag:fragment must be empty, but is not)
		</h3>
		<pe:fragment>
			<jsp:attribute name="fragment">
				<pe:helloWorld />
			</jsp:attribute>
		</pe:fragment>

		<!-- 使用jsp:attribute标签传入fragment参数 -->
		<!-- 下面是动态的JSP页面片段 -->
		
		<h3>下面显示动态属性标签的效果</h3>
		<pe:dynaAttr bookname="javaee开发入门宝典" bookprice="190.00" booktime="2014年12月10号"/>
	</body>
</html>
