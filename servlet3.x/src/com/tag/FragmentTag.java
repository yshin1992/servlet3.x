package com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FragmentTag extends SimpleTagSupport {

	//以页面片段为属性的标签
	private JspFragment fragment;
	
	public JspFragment getFragment() {
		return fragment;
	}

	public void setFragment(JspFragment fragment) {
		this.fragment = fragment;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out=getJspContext().getOut();
		out.print("<div style='padding:10px;border:1px solid lightgray'>");
		out.println("<h3>下面是动态传入的JSP片段</h3>");
		fragment.invoke(null);
		out.println("</div>");
	}
}
