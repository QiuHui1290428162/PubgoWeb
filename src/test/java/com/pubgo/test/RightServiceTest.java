package com.pubgo.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pubgo.dao.RightDao;
import com.pubgo.utils.UserUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RightServiceTest {

	@Resource
	RightDao dao;
	
	@Test
	public void test1() {
		System.out.println(dao.selectRightById("qiu").toString());
	}
	
	@Test
	public void test2() {
		UserUtil util = new UserUtil();
		System.out.println(util.getCustomersID("a06", "account"));
	}
}
