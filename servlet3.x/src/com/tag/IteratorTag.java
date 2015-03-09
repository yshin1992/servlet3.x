package com.tag;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IteratorTag extends SimpleTagSupport{
	//用于指定需要被迭代的集合
	private String collection; 
	//为集合元素指定的名称
	private String item;
	
	//带有属性的标签必须有get,set方法
	public String getCollection() {
		return collection;
	}


	public void setCollection(String collection) {
		this.collection = collection;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	@Override
	public void doTag() throws JspException, IOException {
		Collection itemList=(Collection)getJspContext().getAttribute(collection);
		for(Object s:itemList){
			getJspContext().setAttribute(item, s);
			getJspBody().invoke(null);
		}
	}

}
