package com.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyContextAttributeListener implements
		ServletContextAttributeListener {
	String name;
	Object value;
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		name=event.getName();
		value=event.getValue();
		System.out.println(event.getServletContext()+"范围内添加了名为"+name+"，值为"+value+"的属性!");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		name=event.getName();
		value=event.getValue();
		System.out.println(event.getServletContext()+"范围内删除了名为"+name+"，值为"+value+"的属性!");

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		name=event.getName();
		value=event.getValue();
		System.out.println(event.getServletContext()+"范围内替换了名为"+name+"，值为"+value+"的属性!");

	}

}
