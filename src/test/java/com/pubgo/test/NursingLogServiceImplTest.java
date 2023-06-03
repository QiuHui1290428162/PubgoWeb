package com.pubgo.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pubgo.bean.NursingLog;
import com.pubgo.service.NursingCenterService;
import com.pubgo.service.NursingLogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class NursingLogServiceImplTest {

	@Resource
	private NursingCenterService nursingCenterServiceImpl;
	
	@Resource
	private NursingLogService nursingLogServiceImpl;
	
	@Test
	public void test1() {
		List<NursingLog> nursingLogs = nursingLogServiceImpl.selectByNursingID("H202305060121401816");
		
		System.out.println("**************************************");
		for (NursingLog nursingLog : nursingLogs) {
			nursingLog.toString();
		}
		System.out.println("**************************************");
	}
}
