package com.pubgo.utils;

public class UserAgentUtil {

	/**
	 * 定义移动端请求的所有可能类型
	 */
	private final static String[] agent = { "Android", "iPhone", "iPod","iPad", "Windows Phone", "MQQBrowser" };
	
	/**
	* 	判断User-Agent来自于PC端或移动端
	* @param ua
	* @return     0-PC端，1—移动端
	*/
	public static Integer checkAgent(String ua) {
		Integer flag = 0;
		
		//遍历User-Agent的移动端类型
		for (String item : agent) {
			if (ua.contains(item)) {
				flag = 1;
			}
		}
		
		return flag;
	}
}
