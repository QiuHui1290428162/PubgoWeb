package com.pubgo.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pubgo.utils.ResponseUtil;


/**
 * 	处理统一异常的handler
 * @author Administrator
 *	@ControllerAdvice拦截控制器的异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	//打印错误的日志
	private final Logger log = LoggerFactory.getLogger(
			GlobalExceptionHandler.class);
	
	//拦截业务异常
	@ExceptionHandler(ImoocMallException.class)
	@ResponseBody
	public Object handleImoocMallException(ImoocMallException e) {
		log.error("ImoocMallException", e);
		return new ResponseUtil(e.getCode(), e.getMessage());
	}
	
	
	
	//拦截系统发生异常
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object handleException(Exception e) {
		log.error("Default Exception", e);
		return new ResponseUtil(ImoocMallExceptionEnum.SYSTEM_ERROR);
	}
	
	//拦截校检错误异常
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public Object handleMethodArgumentNotValidException(
		MethodArgumentNotValidException e) {
		log.error("MethodArgumentNotValidException", e);
		return handleBindingResult(e.getBindingResult());
	}
	
	private ResponseUtil handleBindingResult(BindingResult result) {
        //把异常处理为对外暴露的提示
        List<String> list = new ArrayList<String>();
        //hasErrors()返回异常是否包含错误信息
        if (result.hasErrors()) {
        	//获取异常错误信息，并添加到list集合中
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError objectError : allErrors) {
                list.add(objectError.getDefaultMessage());
            }
        }
        //list集合为0，返回参数错误
        if (list.size() == 0) {
            return new ResponseUtil(ImoocMallExceptionEnum.REQUEST_PARAM_ERROR);
        }
        //返回校检错误的信息
        return new ResponseUtil(ImoocMallExceptionEnum.REQUEST_PARAM_ERROR.getCode(), list.toString());
    }
		
	
	

		
		
		
}













