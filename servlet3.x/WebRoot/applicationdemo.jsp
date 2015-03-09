<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application 实例</title>
</head>
<body>
	<%
		String driver = application.getInitParameter( "driver" );
		String url = application.getInitParameter( "url" );
		String passwd = application.getInitParameter( "passwd" );
		String name = application.getInitParameter( "name" );
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName( driver );
			con=DriverManager.getConnection( url,name,passwd );
			stmt=con.createStatement(  );
			rs=stmt.executeQuery( "select * from cities" );
			out.println("<table border=1><tr><th>城市代码</th><th>城市名称</th><th>上级代码</th></tr>");
			while(rs.next(  )){
				out.println("<tr>");
				out.println("<td>"+rs.getString( 1 )+"</td>");
				out.println("<td>"+rs.getString( 2 )+"</td>");
				out.println("<td>"+rs.getString( 3 )+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}catch(Exception e){
		}finally{
			try{
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			}catch(Exception e){
			}
		}
	%>
</body>
</html>