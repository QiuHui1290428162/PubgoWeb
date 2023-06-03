package com.pubgo.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pubgo.service.CategoryService;
import com.pubgo.vo.CategoryVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CategoryServiceImplTest {

	@Resource
	public CategoryService categoryServiceImpl ;
	
	@Test
	public void test1() {
		List<CategoryVo> cs = categoryServiceImpl.listCategory(1);
		for ( CategoryVo c : cs) {
			System.out.println(c.toString());
		}
	}
}
