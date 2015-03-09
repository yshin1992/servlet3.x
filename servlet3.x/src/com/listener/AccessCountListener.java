package com.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AccessCountListener implements ServletContextListener {

	/*
	 * 监听服务器的启动和关闭，实现将用户的访问次数记录到access.properties中去
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		Properties settings = new Properties();
		String accesscount=String.valueOf(arg0.getServletContext().getAttribute("accesscount"));
		settings.put( "accesscount", accesscount);
		
		String fileName=System.getProperty("user.dir")+"\\access.properties";
		FileOutputStream out;
		try {
			out = new FileOutputStream( fileName );
			settings.store( out, fileName );// 以适合使用 load(Reader) 方法的格式，将此 Properties
			// 表中的属性列表（键和元素对）写入输出字符。
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("context over.........");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.err.println("context start.........");
		String fileName=System.getProperty("user.dir")+"\\access.properties";
		System.err.println(fileName+".......");
		File file=new File(fileName);
		Properties settings=new Properties();
		if(file.exists()){
			FileInputStream in;
			try {
				in = new FileInputStream( fileName );
				settings.load( in );
			}  catch (IOException e) {
				e.printStackTrace();
			}
			String accesscount = settings.getProperty( "accesscount" );//读取properties文件中的count属性值
			if(!("null").equals(accesscount)){
				arg0.getServletContext().setAttribute("accesscount", Integer.parseInt(accesscount));
			}else{
				arg0.getServletContext().setAttribute("accesscount", 0);
			}
		}else{
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			arg0.getServletContext().setAttribute("accesscount", 0);//若没有properties文件，先初始accesscount为0
		}
		
	}

}
