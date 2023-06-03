package com.pubgo.test;

import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
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
import com.pubgo.dao.NursingDao;
import com.pubgo.dao.NursingDetailDao;
import com.pubgo.dao.NursingProgressDao;
import com.pubgo.service.NursingService;
import com.pubgo.vo.NursingVO;

import net.coobird.thumbnailator.Thumbnails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class NursingServiceImplTset {

	@Resource
	NursingDao nursingDao;
	@Resource
	NursingDetailDao nursingDetailDao;
	@Resource
	NursingProgressDao nursingProgressDao;
	
	@Resource
	private NursingService nursingServiceImpl;
	@Test
	public void test01() {
		Nursing nursing = new Nursing();
		nursing.setNursingID("HGU"+System.currentTimeMillis());
		nursing.setTel("18820972510");
		nursing.setCustomerID("泥岗");
		nursing.setInput(0);
		nursing.setPayment("护理卡抵扣");
		nursing.setStep(1);
		nursing.setUserRemake("很好");
		nursing.setEmployeeRemake("正在护理");
		nursingDao.insert(nursing);
		
		NursingDetail nursingDetail = new NursingDetail();
		
			nursingDetail.setNursingDetailID(nursing.getNursingID()
					+new DecimalFormat("000").format(1));
			nursingDetail.setNursingID(nursing.getNursingID());
			nursingDetail.setItem("擦鞋");
			nursingDetail.setRenge("擦鞋");
			nursingDetail.setNumber(2);
		
		nursingDetailDao.insert(nursingDetail);
		
		
		NursingProgress nursingProgress1 = new NursingProgress();
		nursingProgress1.setNursingProgressID(nursing.getNursingID()
				+"1");
		nursingProgress1.setNursingID(nursing.getNursingID());
//		nursingProgress1.setInputDate(new Date(System.currentTimeMillis()));
		nursingProgress1.setStep(0);
		nursingProgress1.setOperator("仇");
		nursingProgressDao.insert(nursingProgress1);
		
		NursingProgress nursingProgress2 = new NursingProgress();
		nursingProgress2.setNursingProgressID(nursing.getNursingID()
				+"2");
		nursingProgress2.setNursingID(nursing.getNursingID());
//		nursingProgress2.setInputDate(new Date(System.currentTimeMillis()));
		nursingProgress2.setStep(1);
		nursingProgress2.setOperator("邱");
		nursingProgressDao.insert(nursingProgress2);
	}
	
	@Test
	public void test2(){
		QueryWrapper<Nursing> wrapper = new QueryWrapper<Nursing>();
		wrapper.eq("Tel", "18820972370");
		List<Nursing> nursings = nursingDao.selectList(wrapper);
		for ( Nursing nursing : nursings ) {
			System.out.println(nursing.toString());
		}
		
	}
	
	@Test
	public void test3(){
		nursingServiceImpl.addNursing("18820972370", "qiu", "rh2566", 3, 4, ""
				, 5, "user", "", "", "a01", null, "1", "");
		
	}
	
	@Test
	public void test4(){

		IPage<NursingVO> nursings= nursingServiceImpl.queryNursings("", 0, null, null, 0, "", "", 0, 1, 20, "1");
		System.out.println(nursings.getCurrent());
		System.out.println(nursings.getPages());
		System.out.println(nursings.getTotal());
		System.out.println(nursings.getSize());
		for ( NursingVO nursing : nursings.getRecords() ){
			System.out.println(nursing.toString());
		}
	}
	
	@Test
	public void test5(){

		nursingServiceImpl.deleteNursingID("HL202210011907021133");
	}
	
	@Test
	public void test6(){
		try {
			Thumbnails.of("W:\\PubgoWebImg\\appraise\\1665465804926bbbd52ae106e0fdc7506258f4506082b.jpg")
			.scale(0.25f)
			.toFile("W:\\PubgoWebImg\\appraise\\1665465804926bbbd52ae106e0fdc7506258f4506082b.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
















