package com.pubgo.test;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pubgo.utils.ResponseUtil;
import com.pubgo.api.service.ALSendSmsService;
import com.pubgo.api.service.YZAccessTokenService;
import com.pubgo.api.service.YZCouponService;
import com.pubgo.bean.CheckActivity;
import com.pubgo.bean.CheckKanban;
import com.pubgo.bean.SendSms;
import com.pubgo.property.InformationProperty;
import com.pubgo.service.BuisnessManService;
import com.pubgo.service.CheckActivityService;
import com.pubgo.service.CheckService;
import com.pubgo.service.RightService;
import com.pubgo.service.VipIntegralHisService;
import com.youzan.cloud.open.sdk.common.exception.SDKException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class InformationPropertyTest {

	
	
	@Resource
	public InformationProperty informationProperty;

	
	@Test
	public void test1() {
//		System.out.println(informationProperty.getNursingShoesFileStaticDirectorys());
	}
	
	
}

















































