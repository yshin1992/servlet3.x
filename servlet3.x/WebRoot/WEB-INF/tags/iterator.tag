<%@ tag pageEncoding="utf-8" import="java.util.*"%>

<!-- 定义四个标签属性 -->
<%@ attribute name="bgColor" %>
<%@ attribute name="cellColor" %>
<%@ attribute name="title" %>
<%@ attribute name="bean" %>
<table border=1 bgColor="${bgColor}">
	<tr>
		<td><b>${title }</b></td>
	</tr>
	<% 
		List<String> list=(List<String>)request.getAttribute("bean"); 
		for(Object ele:list){
	%>
	<tr><td bgcolor="${cellColor }"><%=ele %></td></tr>
	<%
	}
	%>
</table>