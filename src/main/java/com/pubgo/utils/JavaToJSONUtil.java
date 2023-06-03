package com.pubgo.utils;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.pubgo.bean.JsonParam;


//阿里云 JSON工具
public class JavaToJSONUtil {

	// Java 变量转JSON 格式的编码
	public static String toJSONString(List<JsonParam> params ) {
		JSONObject object = new JSONObject();
		for ( JsonParam param : params )
		{
			object.put(param.getKey(), param.getValue());
		}
		return object.toJSONString();
	}
}
