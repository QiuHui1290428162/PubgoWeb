package com.pubgo.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pubgo.service.BuisnessManService;
import com.pubgo.service.RightService;
import com.pubgo.utils.UserUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserUtilTest {
	
	@Resource
	private RightService rightServiceImpl;
	
	@Resource
	private BuisnessManService buisnessManServiceImpl;
	
	@Resource
	private UserUtil userUtil;
	
	@Test
	public void test1() {
		System.out.println(userUtil.getCustomersID("a06", "account"));
	}
	
	@Test
	public void test4() {
		rightServiceImpl.queryRightById("a06");
		
		buisnessManServiceImpl.queryBuisnessMan("w01");
	}
}

















































