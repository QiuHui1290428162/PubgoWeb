package com.pubgo.filter;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//打印请求和响应信息
@Aspect
@Component
public class WebLogAspect {

	private final  Logger log = LoggerFactory.getLogger(WebLogAspect.class) ;
	
	//指定拦截点controller包下的所有类
	@Pointcut("execution(public * com.pubgo.controller.*.*(..))")
	public void webLog() {
		
	}
	
	//controller类执行前，打印请求
	@Before("webLog()")
	public void  doBefore(JoinPoint joinPoint) {
		//获取请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) 
				RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		//打印请求的URL地址
		log.info("URL: "+request.getRequestURI().toString());
		//打印请求的类型：get，post，put
		log.info("HTTP_METHOD: "+request.getMethod());
		//打印请求客户端的IP
		log.info("IP: "+request.getRemoteAddr());
		//打印controller类的方法名称和参数
		log.info("CLASS_METHOD: "+joinPoint.getSignature().getDeclaringTypeName()
				+"."+joinPoint.getSignature().getDeclaringTypeName());
		log.info("ARGS: "+Arrays.toString(joinPoint.getArgs()));
		
	}
	
	//controller类执行后，打印响应内容
	@AfterReturning(returning = "res", pointcut = "webLog()")
	public void doAfterReturning(Object res) throws JsonProcessingException{
		//处理完请求后，打印响应内容
		log.info("RESPONSE: "+ new ObjectMapper().writeValueAsString(res));
	}
}















