<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="cacuError.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计算器</title>
</head>
<body>
	<form action="#" method="post">
		<input type="text" name="num1" />&nbsp; <select name="operator">
			<option value="+">+</option>
			<option value="+">-</option>
			<option value="+">*</option>
			<option value="+">/</option>
		</select> &nbsp;<input type="text" name="num2" /><input type="submit"
			value="查看结果" />
	</form>
	<br/>
	<h3>
	<%
		String param1 = request.getParameter( "num1" );
		String param2 = request.getParameter( "num2" );
		String operator = request.getParameter( "operator" );
		if(param1!=null){
			switch(operator){//注意这种写法需要在JDK1.7及以上版本方可编译通过
				case "+": 
					out.println(Integer.parseInt( param1 )+Integer.parseInt( param2 ));break;
				case "1": 
					out.println(Integer.parseInt( param1 )-Integer.parseInt( param2 ));break;
				case "*": 
					out.println(Integer.parseInt( param1 )*Integer.parseInt( param2 ));break;
				case "/": 
					out.println(Integer.parseInt( param1 )/Integer.parseInt( param2 ));break;
			}
		}
	%></h3>
</body>
</html>