package com.pubgo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pubgo.service.CategoryService;
import com.pubgo.utils.ResponseUtil;
import com.pubgo.utils.UserAgentUtil;
import com.pubgo.vo.CategoryVo;


/**
 * 	应用目录控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/category/")
public class CategoryController {

	@Resource
	private CategoryService categoryServiceImpl;
	
	//查询目录列表
	@GetMapping("list/quest")
	public ResponseUtil listCategory(HttpServletRequest request, HttpServletResponse response) {
		//获取请求头的User-Agent值，判断是PC端，还是移动端
		String ua = request.getHeader("User-Agent");
		List<CategoryVo> categoryVos = categoryServiceImpl.listCategory(UserAgentUtil.checkAgent(ua));
		return new ResponseUtil().put("categoryVos", categoryVos);
	}
}














