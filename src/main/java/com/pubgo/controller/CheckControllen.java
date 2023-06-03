package com.pubgo.controller;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pubgo.bean.CheckKanban;
import com.pubgo.exception.ImoocMallExceptionEnum;
import com.pubgo.request.QueryCheckKanban;
import com.pubgo.service.CheckService;
import com.pubgo.utils.Constant;
import com.pubgo.utils.ResponseUtil;
import com.pubgo.utils.UserUtil;

/**
 * 	店铺销售控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/check/")
public class CheckControllen {

	@Resource
	private UserUtil userUtil;
	
	@Resource
	private CheckService checkServiceImpl;
	
	//销售看板
	@PostMapping("query/kanban")
	public ResponseUtil checkLogin(@Valid @RequestBody QueryCheckKanban queryCheckKanban 
			, HttpSession session) {
		//校检  开始日期不能大于结束日期
		if ( queryCheckKanban.getStartDate().getTime()>queryCheckKanban.getEndDate().getTime() ) {
			return new ResponseUtil(ImoocMallExceptionEnum.NOT_DATE);
		}
		
		//创建日期类，获取去年的日期
		Calendar startCal = Calendar.getInstance(); 
		startCal.setTime(queryCheckKanban.getStartDate());
		startCal.add(Calendar.YEAR, -1);
		Calendar endCal = Calendar.getInstance(); 
		endCal.setTime(queryCheckKanban.getEndDate());
		endCal.add(Calendar.YEAR, -1);
		
		//获取今年销售看板
		CheckKanban currentKanban = checkServiceImpl.queryCheckKanban(
				userUtil.getCustomersID((String)session.getAttribute(Constant.ID)
						,(String)session.getAttribute(Constant.TYPE))
				, queryCheckKanban.getStartDate(), queryCheckKanban.getEndDate());
		//若销售看板为null，则重置为0
		if ( currentKanban == null ) {
			currentKanban = new CheckKanban();
		}
		
		//获取去年的销售看板
		CheckKanban previouslyKanban = checkServiceImpl.queryCheckKanban(
				userUtil.getCustomersID((String)session.getAttribute(Constant.ID)
						,(String)session.getAttribute(Constant.TYPE))
					, startCal.getTime(), endCal.getTime());
		if ( previouslyKanban == null ) {
			previouslyKanban = new CheckKanban();
		}
		
		//获取今年与去年的销售看板
		ResponseUtil resp = new ResponseUtil().put("CurrentKanban", currentKanban)
				.put("PreviouslyKanban", previouslyKanban);
		return resp;
	}
}
