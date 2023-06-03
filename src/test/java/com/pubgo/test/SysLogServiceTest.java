package com.pubgo.test;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pubgo.bean.SysLog;
import com.pubgo.dao.SysLogDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SysLogServiceTest {

	@Resource
	private SysLogDao sysLogDao;
	
	@Test
	public void test1() {
		//记录日志
		SysLog log = new SysLog();
		log.setClientHost("PubgoWeb");
		log.setUserNo("测试账号");
		log.setLogTime(new Timestamp(System.currentTimeMillis()));
		log.setModuleName("护理管理");
		log.setAction("删除");
		log.setRemark("测试");
		
		sysLogDao.insertLog(log);
	}
}
