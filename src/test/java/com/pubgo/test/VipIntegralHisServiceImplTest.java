package com.pubgo.test;

import java.sql.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.pubgo.bean.VIPIntegralExchange;
import com.pubgo.bean.VipIntegralHis;
import com.pubgo.dao.VIPIntegralExchangeDao;
import com.pubgo.dao.VipIntegralHisDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class VipIntegralHisServiceImplTest {

	@Resource
	VipIntegralHisDao vipIntegralHisDao;
	@Resource
	VIPIntegralExchangeDao vipIntegralExchangeDao;
	
	@Test
	public void test1(){
		UpdateWrapper<VipIntegralHis> wrapper = new UpdateWrapper<VipIntegralHis>();
		wrapper.eq("VIP", "18820972370");
		
		VipIntegralHis vipIntegralHis = new VipIntegralHis();
		vipIntegralHis.setSaveDate(new Date(System.currentTimeMillis()));
		vipIntegralHis.setIntegralAmount(2000);
		
		
		vipIntegralHisDao.update(vipIntegralHis, wrapper);
	}
	
	@Test
	public void test2(){
		VIPIntegralExchange integralExchange = new VIPIntegralExchange();  
		integralExchange.setVip("18820972370");
		integralExchange.setExchangeDate(new Date(System.currentTimeMillis()));
		integralExchange.setInputDate(new Date(System.currentTimeMillis()));
		integralExchange.setPostedDate(new Date(System.currentTimeMillis()));
		integralExchange.setOperator("qiu");
		integralExchange.setAmount(-200);
		integralExchange.setPostUser("qoi");
		integralExchange.setRemark("nihao");
		
		vipIntegralExchangeDao.insertOne(integralExchange);
	}
}
