package servlet.episode3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  A More Holistic Counter 
 */
public class HolisticCounter extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	static int classCount = 0;// shared by all instances

	int count = 0; // separate for each servlet

	static Hashtable instances = new Hashtable(); // also shared


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType( "text/plain" );
		PrintWriter out = res.getWriter();

		count++;
		out.println( "Since loading, this servlet instance has been accessed " + count + " times." );

		// Keep track of the instance count by putting a reference to this
		// instance in a hashtable. Duplicate entries are ignored.
		// The size() method returns the number of unique instances stored.
		instances.put( this, this );
		out.println( "There are currently " + instances.size() + " instances." );

		classCount++;
		out.println( "Across all instances, this servlet class has been " + "accessed " + classCount + " times." );

	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		this.doGet( req, resp );
	}

}
