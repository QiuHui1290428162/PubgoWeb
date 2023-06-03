package com.pubgo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pubgo.utils.Constant;
import com.pubgo.utils.ResponseUtil;
import com.pubgo.bean.BuisnessMan;
import com.pubgo.bean.Right;
import com.pubgo.exception.ImoocMallExceptionEnum;
import com.pubgo.service.BuisnessManService;
import com.pubgo.service.RightService;

/**
 * 	用户登录控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	@Resource
	private RightService rightServiceImpl;
	
	@Resource
	private BuisnessManService buisnessManServiceImpl;
	
	/**
	 * 校检用户登录
	 * @param id    账号id（员工号/店铺号）
	 * @param session
	 * @return
	 */
	@PostMapping("/post")
	public ResponseUtil Login( String id, HttpSession session) {
		ResponseUtil resp =  new ResponseUtil();
		
		//判断字符是否为null或空字符
		if ( StringUtils.isEmpty(id) ) {
			return new ResponseUtil(ImoocMallExceptionEnum.NEED_USER_NAME);
		}
		
		//校检丽晶账号登录
		Right right = rightServiceImpl.queryRightById(id);
			
		//若不是丽晶账号，则检验员工号登录
		if (right == null) {
			BuisnessMan buisnessMan = buisnessManServiceImpl.queryBuisnessMan(id);
			if ( buisnessMan != null ) {
				//保存员工信息到网站session
				session.setAttribute(Constant.ID, buisnessMan.getBuisnessManID());
				session.setAttribute(Constant.NAME, buisnessMan.getName());
				session.setAttribute(Constant.TYPE, "staff");   //登录类型:员工号
			}else {
				//账号不存在
				resp = new ResponseUtil(ImoocMallExceptionEnum.NOT_USER_EXIST);
			}
		}else {
			//保存丽晶账号信息到网站session
			session.setAttribute(Constant.ID, right.getUserNo().trim());
			session.setAttribute(Constant.NAME, right.getUserName().trim());
			session.setAttribute(Constant.TYPE, "account");   //登录类型:丽晶账号
		}
		return resp.put("id", session.getAttribute(Constant.ID)).put("name", session.getAttribute(Constant.NAME)).put("type", session.getAttribute(Constant.TYPE));
		
	}
	
	/**
	 * 	校验登录，获取id和name
	 * @param session
	 * @return
	 */
	@GetMapping("/get")
	public ResponseUtil checkLogin (HttpSession  session) {
		
		ResponseUtil resp =  new ResponseUtil();
		return resp.put("id", session.getAttribute(Constant.ID)).put("name", session.getAttribute(Constant.NAME)).put("type", session.getAttribute(Constant.TYPE));
	}

	/**
	 * 	校验员工号登录
	 * @param session
	 * @return
	 */
	@GetMapping("/getStaff")
	public ResponseUtil checkLoginStaff (HttpSession  session) {
		
		return new ResponseUtil();
	}
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@PostMapping("/delete")
	public ResponseUtil delectLogin ( HttpSession  session) {
		//清除session状态
		session.removeAttribute(Constant.ID);
		session.removeAttribute(Constant.NAME);
		return new ResponseUtil() ;
	}
}
 