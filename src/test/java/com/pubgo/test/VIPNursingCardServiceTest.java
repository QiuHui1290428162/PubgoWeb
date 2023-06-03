package com.pubgo.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pubgo.service.VIPNursingCardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class VIPNursingCardServiceTest {

	@Resource
	private VIPNursingCardService vipNursingCardServiceImpl;
	
	@Test
	public void test1() {
		
		System.out.println(vipNursingCardServiceImpl.queryNursingCardOne("18820972370"));
	}
}
