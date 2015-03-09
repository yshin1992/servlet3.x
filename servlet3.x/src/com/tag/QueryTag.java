package com.tag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class QueryTag extends SimpleTagSupport {

	// 标签的属性
	private String driver;
	private String url;
	private String user;
	private String pswd;
	private String sql;

	private Connection con = null;

	private Statement stmt = null;

	private ResultSet rs = null;

	private ResultSetMetaData rsmd = null;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public void doTag() throws JspException, IOException {
		try {
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,user,pswd);
			
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			rsmd=rs.getMetaData();
			
			JspWriter out=getJspContext().getOut();
			
			out.println("<table border=1>");
			while(rs.next()){
				out.println("<tr>");
				for(int i=1;i<=rsmd.getColumnCount();i++){
					out.println("<td>"+rs.getString(i)+"</td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (Exception r) {
			r.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
