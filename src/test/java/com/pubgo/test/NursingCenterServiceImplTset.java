package com.pubgo.test;

import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pubgo.bean.Nursing;
import com.pubgo.bean.NursingDetail;
import com.pubgo.bean.NursingProgress;
import com.pubgo.dao.NursingCenterDao;
import com.pubgo.dao.NursingDao;
import com.pubgo.dao.NursingDetailDao;
import com.pubgo.dao.NursingProgressDao;
import com.pubgo.service.NursingCenterService;
import com.pubgo.service.NursingService;
import com.pubgo.vo.NursingCenterVO;
import com.pubgo.vo.NursingDetailsVo;
import com.pubgo.vo.NursingVO;

import net.coobird.thumbnailator.Thumbnails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class NursingCenterServiceImplTset {

	@Resource
	private NursingCenterDao nursingCenterDao;
	
	@Resource
	private NursingCenterService nursingCenterServiceImpl;
	
	
	@Test
	public void test01() {
		List<String> customerIds = new ArrayList<>();
		customerIds.add("全部");
		IPage<NursingCenterVO> nursingVO = nursingCenterServiceImpl.queryNursings("星港城松岗店", 0, null, null, customerIds, 0, 1, 50, "1");
		for (NursingCenterVO vo : nursingVO.getRecords()) {
			vo.toString();
		}
	}
	
	@Test
	public void test02() {
		NursingDetailsVo vo = nursingCenterDao.selectNursingDetails("H202305050259391242");
		System.out.println(vo.toString());
	}
}
















