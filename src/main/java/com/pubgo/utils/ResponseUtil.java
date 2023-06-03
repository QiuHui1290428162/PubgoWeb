package com.pubgo.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pubgo.exception.ImoocMallExceptionEnum;

//处理请求编码类
public class ResponseUtil {


	private Integer code;        //状态码
	private String msg;         //状态描述
	private Map<Object, Object> data = new LinkedHashMap<Object, Object>();
	
	//默认处理成功
	public ResponseUtil() {
		this.code = 200;
		this.msg = "success";
	}
	
	//处理失败
	public ResponseUtil(ImoocMallExceptionEnum ex) {
		this.code = ex.getCode() ;
		this.msg = ex.getMsg();
	}
	
	public ResponseUtil( Integer code, String msg ) {
		this.code = code ;
		this.msg = msg;
	}
	
	//封装数据或错误信息源
	public ResponseUtil put(String key,Object value) {
		this.data.put(key, value);
		return this;
	}
	
	//将data实例 序列化
	public String toJsonString() {
		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.setSerializationInclusion(JsonInclude.Include);
		try {
			String json = objectMapper.writeValueAsString(this);
			return json;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String message) {
		this.msg = message;
	}
	public Map getData() {
		return data;
	}
	public void setData(Map data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseUtils [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
