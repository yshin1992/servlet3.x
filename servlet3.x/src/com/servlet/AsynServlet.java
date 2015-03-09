package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.listener.MyAsyncLitener;

@WebServlet(urlPatterns="/aysnc",asyncSupported=true)
public class AsynServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<title>异步调用调试</title>");
		out.println("进入Servlet的时间:"+new java.util.Date()+"<br />");
		out.flush();
		//开始创建AsyncContext,开始异步调用
		AsyncContext actx=request.startAsync();
		//添加监听器
		actx.addListener(new MyAsyncLitener());
		//设置异步调用的超时时长
		actx.setTimeout(30*1000);
		//启动异步调用的线程
		actx.start(new Executor(actx));
		out.println("结束Servlet的时间:"+new java.util.Date()+"<br />");
		out.flush();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
