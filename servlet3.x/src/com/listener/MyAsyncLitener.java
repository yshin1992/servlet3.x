package com.listener;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

/*
 * 异步调用监听器
 */
public class MyAsyncLitener implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent arg0) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("----调用完成-----");
	}

	@Override
	public void onError(AsyncEvent arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStartAsync(AsyncEvent arg0) throws IOException {
		System.out.println("----调用开始-----");//这一段话没有输出，可能是因为注册该监听器时，异步调用已经开始
	}

	@Override
	public void onTimeout(AsyncEvent arg0) throws IOException {
		// TODO Auto-generated method stub

	}

}
