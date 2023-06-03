package com.pubgo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pubgo.utils.Constant;
import com.pubgo.utils.ResponseUtil;
import com.pubgo.bean.BuisnessMan;
import com.pubgo.service.BuisnessManService;
import com.pubgo.service.VipIntegralHisService;

/**
 * 	会员积分控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/vip/integral")
public class IntegralController {

	@Resource
	private VipIntegralHisService vipIntegralHisService;
	
	@Resource
	private BuisnessManService buisnessManServiceImpl;
	/**
	 *  	修改会员积分
	 * @param payment       结算方式:integral-积分抵扣护理服务
	 * @param vip           会员号
	 * @param integral      会员积分
	 * @param integralChange   消除会员积分
	 * @param remark        备注
	 * @return
	 */
	@PostMapping("/updateIntegral")
	public ResponseUtil editVipIntegral(String payment, String vip, Integer integral
			, Integer integralChange, String remark, HttpSession session) {
		ResponseUtil resp = new ResponseUtil();

		//获取员工信息
		BuisnessMan buisnessMan = buisnessManServiceImpl
			.queryBuisnessMan((String)session.getAttribute(Constant.ID));
		
		if ( payment.equals("integral") ) {
			vipIntegralHisService.editIntegralHis(vip, integral
				, integralChange, buisnessMan.getName()
				, buisnessMan.getCustomerID(), remark);
		}


		
		return resp;
	}
}
