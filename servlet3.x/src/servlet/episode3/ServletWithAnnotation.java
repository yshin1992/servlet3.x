package servlet.episode3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用Annotation方式实现对于请求的响应
 */
@WebServlet(urlPatterns = { "/ServletWithAnnotation"})
public class ServletWithAnnotation extends HttpServlet
{
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 使用service方法实现包括(get,put,post,delete)的所有请求 
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding( "text/html;charset=utf-8" );
		out.println( "Hello,this servlet not use the web.xml!" );
	}

}
