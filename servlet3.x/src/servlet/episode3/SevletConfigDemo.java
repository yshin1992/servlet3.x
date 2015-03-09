package servlet.episode3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SevletConfigDemo
 */
@WebServlet(urlPatterns = { "/SevletConfigDemo" }, initParams = {
		@WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"),
		@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/test"), @WebInitParam(name = "user", value = "root"),
		@WebInitParam(name = "pswd", value = "") })
public class SevletConfigDemo extends HttpServlet
{
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ServletConfig config = getServletConfig();
		String driver = config.getInitParameter( "driver" );
		String url = config.getInitParameter( "url" );
		String passwd = config.getInitParameter( "pswd" );
		String name = config.getInitParameter( "user" );

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			Class.forName( driver );
			con = DriverManager.getConnection( url, name, passwd );
			stmt = con.createStatement();
			rs = stmt.executeQuery( "select * from cities" );
			out.println( "<table border=1><tr><th>城市代码</th><th>城市名称</th><th>上级代码</th></tr>" );
			while (rs.next())
			{
				out.println( "<tr>" );
				out.println( "<td>" + rs.getString( 1 ) + "</td>" );
				out.println( "<td>" + rs.getString( 2 ) + "</td>" );
				out.println( "<td>" + rs.getString( 3 ) + "</td>" );
				out.println( "</tr>" );
			}
			out.println( "</table>" );
			out.flush();
		}
		catch (Exception e)
		{
		}
		finally
		{
			try
			{
				out.close();
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			}
			catch (Exception e)
			{
			}
		}
	}

}
