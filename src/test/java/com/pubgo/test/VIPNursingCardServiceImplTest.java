package com.pubgo.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pubgo.bean.VIPNursingCard;
import com.pubgo.dao.VIPNursingCardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class VIPNursingCardServiceImplTest {

	@Resource
	private VIPNursingCardDao vipNursingCardDao;
	
	@Test
	public void test1() {
		QueryWrapper<VIPNursingCard> wrapper = new QueryWrapper<VIPNursingCard>();
		wrapper.eq("Vip", "18820972318");
		
		System.out.println(vipNursingCardDao.selectOne(wrapper));
	}
}
