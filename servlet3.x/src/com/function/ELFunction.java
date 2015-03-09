package com.function;

public class ELFunction {

	/*
	 * 创建EL表达式的自定义函数
	 */
	public static String reverse(String str){
		return new StringBuffer(str).reverse().toString();
	}
	
	public static int charLen(String str){
		return str.length();
	}
}
