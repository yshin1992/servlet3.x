package com.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class MyServletReqestListener implements ServletRequestListener,
		ServletRequestAttributeListener {
	String name;
	Object value;
	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		// TODO Auto-generated method stub
		name=event.getName();
		value=event.getValue();
		System.out.println(event.getServletRequest()+"范围内添加了名为"+name+"，值为"+value+"的属性!");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		name=event.getName();
		value=event.getValue();
		System.out.println(event.getServletRequest()+"范围内删除了名为"+name+"，值为"+value+"的属性!");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		name=event.getName();
		value=event.getValue();
		System.out.println(event.getServletRequest()+"范围内替换了名为"+name+"，值为"+value+"的属性!");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		HttpServletRequest req=(HttpServletRequest)arg0.getServletRequest();
		System.out.println("--发向"+req.getRequestURI()+"被销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		HttpServletRequest req=(HttpServletRequest)arg0.getServletRequest();
		System.out.println("--发向"+req.getRequestURI()+"被初始化");
	}

}
