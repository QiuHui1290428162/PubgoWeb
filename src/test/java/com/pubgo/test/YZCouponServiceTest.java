package com.pubgo.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pubgo.api.service.YZCouponService;
import com.youzan.cloud.open.sdk.common.exception.SDKException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class YZCouponServiceTest {

	@Resource
	public YZCouponService yzCouponServiceImpl;

	
	@Test
	public void test1() {
		try {
			yzCouponServiceImpl.couponConsumeVerif("255bdce834dc70a3c8b0b18cfa63e18", "ZAN927361944754");
		} catch (SDKException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
