package com.pubgo.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pubgo.bean.Vip;
import com.pubgo.dao.CustomerVIPDao;
import com.pubgo.service.CustomerVIPService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CustomerVIPServiceTest {

	@Resource
	CustomerVIPService customerVIPServiceImpl;
	
	@Resource
	private CustomerVIPDao customerVIPDao;
	
	@Test
	public void test01() {
		customerVIPDao.selectById("18820972370");
		
	}
	
	@Test
	public void test02() {
		Vip entity = new Vip();
		entity.setVip("18820972370");
		entity.setHisIntegral(5000);
		
		customerVIPDao.updateById(entity);
		System.out.println(customerVIPDao.selectById("18820972370"));
	}
	
	@Test
	public void test03() {
		System.out.println(System.currentTimeMillis());
		
	}
}
