package com.pubgo.controller.Client;

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
@RequestMapping("/frontEnd/vip/integral")
public class IntegralClientController {

	@Resource
	private VipIntegralHisService vipIntegralHisService;
	
	@Resource
	private BuisnessManService buisnessManServiceImpl;
	/**
	 *  	修改会员积分
	 * @param payment     结算方式:integral-积分抵扣护理服务
	 * @param vip         会员号
	 * @param integral    会员积分
	 * @param integralChange   消除会员积分   
	 * @param postUser    店铺号
	 * @param remark      备注
	 * @return
	 */
	@PostMapping("/updateIntegral")
	public ResponseUtil editVipIntegral(String payment, String vip, Integer integral
			, Integer integralChange, String postUser, String remark) {
		ResponseUtil resp = new ResponseUtil();
;
		
		if ( payment.equals("integral") ) {
			vipIntegralHisService.editIntegralHis(vip, integral
				, integralChange, "", postUser, remark);
		}


		
		return resp;
	}
}
