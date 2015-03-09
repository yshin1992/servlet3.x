package com.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;

public class Executor implements Runnable {

	private AsyncContext actx=null;
	
	public Executor(AsyncContext actx){
		this.actx=actx;
	}
	@Override
	public void run() {
		try{
			//等待5秒钟，以模拟业务方法的执行
			Thread.sleep(5000);
			ServletRequest request=actx.getRequest();
			List<String> books=new ArrayList<String>();
			books.add("疯狂Java讲义");
			books.add("经典Java EE企业实用实战");
			books.add("疯狂XML讲义");
			request.setAttribute("books", books);
			actx.dispatch("/async.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
