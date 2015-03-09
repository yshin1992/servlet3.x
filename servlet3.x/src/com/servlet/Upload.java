package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class Upload extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Upload() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取普通请求参数
		String fileName=request.getParameter("name");
		//获取文件上传域
		Part part=request.getPart("file");
		//获取上传文件的类型
		out.println("上传文件的类型为:"+part.getContentType()+"<br/>");
		//获取上传文件的大小
		out.println("上传文件的大小为:"+part.getSize()+"<br/>");
		//获取该文件上传域的Header Name
		Collection<String> headerNames=part.getHeaderNames();
		//遍历文件上传域的Header Name,value
		for(String headerName:headerNames){
			out.println(headerName+"--->"+part.getHeader(headerName));
		}
		System.out.println(getServletContext().getRealPath("/")+"-------<>");
		part.write(getServletContext().getRealPath("/")+"/uploads/"+fileName);
		
//		java.util.UUID.randomUUID().toString();
	}

}
