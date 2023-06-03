package com.pubgo.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pubgo.api.service.ALSendSmsService;
import com.pubgo.bean.CheckActivity;
import com.pubgo.bean.JsonParam;
import com.pubgo.bean.SendSms;
import com.pubgo.service.CheckService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ALSendSmsServiceImplTest {
	
	@Resource
	public ALSendSmsService  alSendSmsServiceimpl;
	
	@Resource
	public CheckService checkServiceImpl;

	@Test
	public void test1() {
		SendSms sms = alSendSmsServiceimpl.querySendSmsByName("验证码短信");
		sms.getTemplateParams().get(0).setValue("2375");;	
		System.out.println(alSendSmsServiceimpl.send("18820972370", sms));;
		System.out.println(sms.toString());
		
		
		
	}
	
	@Test
	public void test2() throws JsonProcessingException {
		JsonParam a = new JsonParam();
		a.setKey("code");
		a.setValue("2375");
		JsonParam b = new JsonParam();
		b.setKey("code");
		b.setValue("2375");
		
		ArrayList<JsonParam> params = new ArrayList<JsonParam>();
		params.add(a);
		params.add(b);
		
		//Jackson 反序列化
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(params));
		
		//阿里Jackson 反序列化
		JSONObject object = new JSONObject();
		for ( JsonParam param : params )
		{
			object.put(param.getKey(), param.getValue());
		}
		System.out.println(object.toJSONString());
	}
	
	@Test
	public void test3() {
		List<CheckActivity> checkActivitys = checkServiceImpl.queryCheckSale();
		for ( CheckActivity checkActivity : checkActivitys ) {
			checkActivity.toString();
		}
		
		
		
	}
}
