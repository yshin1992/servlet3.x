package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter(urlPatterns="/*",asyncSupported=true)
public class LogFilter implements Filter {

	//FilterConfig可用于访问Filter的配置信息
    private FilterConfig config;
    private static int accesscount;
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.config=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.err.println(accesscount++);//访问次数加1
		ServletContext ctx=this.config.getServletContext();
		ctx.setAttribute("accesscount", accesscount);
		long before=System.currentTimeMillis();
		System.out.println("开始过滤..");
		//将请求转换成HttpServletRequest请求
		HttpServletRequest req=(HttpServletRequest)request;
		System.out.println("Filter已经截获到用户的请求 ："+req.getServletPath());
		//Filter只是链式处理，请求依然放行到目的地址
		chain.doFilter(request, response);
		
		//下面代码用于对服务器响应执行后处理
		long after=System.currentTimeMillis();
		
		System.out.println("过滤结束");
		System.out.println("请求被定为到"+req.getRequestURL()+"所花时间: "+(after-before));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config=fConfig;
		this.accesscount=(Integer)fConfig.getServletContext().getAttribute("accesscount");
	}

}
