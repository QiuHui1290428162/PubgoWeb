package com.pubgo.exception;

//统一异常处理
public class ImoocMallException extends RuntimeException {

	private final Integer code;
	private final String msg;
	
	public ImoocMallException(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public  ImoocMallException( ImoocMallExceptionEnum exceptionEnum ) {
		this(exceptionEnum.getCode(), exceptionEnum.getMsg());
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
