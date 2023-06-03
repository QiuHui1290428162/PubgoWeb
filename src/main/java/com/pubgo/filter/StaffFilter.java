package com.pubgo.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import com.pubgo.utils.Constant;

//员工号登录过滤链
public class StaffFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	/**
	 *  FilterChain chain  过滤链
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		///获取网站session用户数据
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpSession session = request.getSession();
		//校验账号类型是否是员工登录
		if( !Constant.STAFF.equals(session.getAttribute(Constant.TYPE)) ) {
			//响应错误代码
			//设置服务器和客户端都使用 UTF-8 字符集，还设置了响应头 
			//此方法一定要在获取流对象之前调用才有效 
			servletResponse.setContentType("text/html; charset=UTF-8");
			PrintWriter out = new HttpServletResponseWrapper(
				(HttpServletResponse)servletResponse).getWriter();
			out.write("{"
					+ "\"code\":10004,"
					+ "\"msg\":\"请用员工号登录，再使用该功能\","
					+ "\"data\":\"\""
					+ "}");
			out.flush();
			out.close();
			return;
		}
		//将请求响应向后传递，被后续的Filter或者Servlet进行处理		
		chain.doFilter(servletRequest, servletResponse);
	}
}
