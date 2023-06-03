package com.pubgo.api.service;

import com.pubgo.bean.SendSms;

//阿里短信API业务层
public interface ALSendSmsService {

	//根据短信模板名称查询短信模板表
	public SendSms querySendSmsByName (String templateName);
	
	//调用阿里云短信服务API，发送短信
	public String send (String tel,SendSms sendSms);
}
