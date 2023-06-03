package com.pubgo.test;

import java.util.ArrayList;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pubgo.bean.CStock;
import com.pubgo.dao.CStockDao;
import com.pubgo.service.CStockService;
import com.pubgo.vo.NursingVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CStockServiceImplTest {

	@Resource
	CStockDao dao;
	@Resource
	CStockService cStockServiceImpl;
	
	@Test
	public void test1() {
		ArrayList<String> s = new ArrayList<String>();
		s.add("C01");
		s.add("gd048");
		s.add("a08");
		
		IPage<CStock> p = new Page<CStock>(1, 100);
		
		
		System.out.println(dao.selectCStocks("w1002101", s, p).toString());
	}
	@Test
	public void test2() {
		ArrayList<String> s = new ArrayList<String>();
		s.add("C01");
		s.add("gd048");
		s.add("a08");
		
		
		IPage<CStock> p= cStockServiceImpl.QueryCustomerStocks("45 ", s, 1, 50);
		System.out.println(p.getCurrent());
		System.out.println(p.getPages());
		System.out.println(p.getTotal());
		System.out.println(p.getSize());
		for ( CStock c : p.getRecords() ){
			System.out.println(c.toString());
		}
	}
}
