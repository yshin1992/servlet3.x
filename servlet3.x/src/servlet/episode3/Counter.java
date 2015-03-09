package servlet.episode3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A simple counter
 */
@WebServlet("/Counter")
public class Counter extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	int count;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType( "text/plaint;charset=utf-8" );
		PrintWriter out = response.getWriter();
		synchronized (this)
		{
			count++;
			out.print( "Since loading , this class has been access " + count + " times." );
		}

	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.doGet( request, response );
	}

}
