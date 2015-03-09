package com.listener;

import java.util.Hashtable;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     * 每打开一个新的会话，将其保存到online中
     */
    public void sessionCreated(HttpSessionEvent arg0) {
    	HttpSession session=arg0.getSession();
    	Hashtable<String,String> online=(Hashtable<String, String>) session.getServletContext().getAttribute("online");
    	//如果是一个新的会话
    	if(session.isNew()){
    		if(online==null){
    			online=new Hashtable<String,String>();
    		}
    		online.put(session.getId(), "游客");
    		session.getServletContext().setAttribute("online",online);
    	}
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     * 销毁会话时将其从online中移除
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
    	ServletContext ctx=arg0.getSession().getServletContext();
    	Hashtable<String,String> online=(Hashtable<String, String>)ctx.getAttribute("online");
    	String sessionId=arg0.getSession().getId();
    	System.out.println(sessionId);
    	if(online!=null){
    		online.remove(sessionId);
    	}
    	ctx.setAttribute("online",online);
    }
	
}
