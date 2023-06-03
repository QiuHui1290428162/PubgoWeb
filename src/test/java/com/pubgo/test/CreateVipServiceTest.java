package com.pubgo.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pubgo.service.CheckService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CreateVipServiceTest {

		
	@Resource
	private CheckService checkServiceIpml;
	
	@Test
	public void test1() {
		System.out.println(checkServiceIpml.queryCheckSale().toString());
	}

}
