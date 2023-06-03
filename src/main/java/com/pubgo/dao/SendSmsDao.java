package com.pubgo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pubgo.bean.SendSms;

public interface SendSmsDao extends BaseMapper<SendSms>{

	//根据名称查询模板
	public SendSms selectSmsByName(String templateName);
}
