package com.pubgo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pubgo.utils.NumberValidationUtil;
import com.pubgo.utils.ResponseUtil;
import com.pubgo.bean.VIPNursingCard;
import com.pubgo.bean.Vip;
import com.pubgo.bean.VipIntegralHis;
import com.pubgo.exception.ImoocMallExceptionEnum;
import com.pubgo.service.CustomerVIPService;
import com.pubgo.service.NursingService;
import com.pubgo.service.VIPNursingCardService;
import com.pubgo.service.VipIntegralHisService;

// 客户VIP控制器
@RestController
@RequestMapping("/vip")
public class CustomerVipController {
	
	@Resource
	private CustomerVIPService customerVIPServiceImpl;
	@Resource
	private NursingService nursingVIPServiceImpl;
	@Resource
	private VipIntegralHisService vipIntegralHisServiceImpl;
	@Resource
	private VIPNursingCardService vipNursingCardServiceImpl;
	/**
	 * 	校检手机号
	 * @param vip   手机号
	 * @return   会员信息
	 */
	@GetMapping("/checkVip")
	public  ResponseUtil checkVip(String tel) {
		ResponseUtil resp = new ResponseUtil();
		
		//校检手机号格式
		if( !NumberValidationUtil.isNumeric(tel) || tel.length()!=11) {
			return new ResponseUtil(ImoocMallExceptionEnum.NOT_TEl_FORMAT);
		}
		
		//查询会员
		Vip vip = customerVIPServiceImpl.queryVipByID(tel);
		//校验会员是否存在，存在则查询护理卡时效或积分，若不存在则查询用户护理次数
		if ( vip != null ) {
			VIPNursingCard card = vipNursingCardServiceImpl.queryNursingCardOne(tel);
			if ( card == null )
			{
				//VIP护理卡不存在
				return new ResponseUtil(ImoocMallExceptionEnum.NOT_VIPNURSINGCARD_EXIST);
			}
			//校检护理卡是否失效，若失效则查询会员积分
			if ( card.getExpireDate().getTime() > System.currentTimeMillis()) {
				resp.put("nursingCard", card)
						.put("vip", vip).put("payment", "nursingCard");
			}
			else {
				VipIntegralHis vipIntegralHis = vipIntegralHisServiceImpl.queryIntegralHis(tel);
				//若会员积分表不存在，则创建积分表
				if ( vipIntegralHis == null ) 
				{
					vipIntegralHisServiceImpl.addIntegralHis(tel, 0);
					vipIntegralHis = vipIntegralHisServiceImpl.queryIntegralHis(tel);
				}
				resp.put("integral", vipIntegralHis)
						.put("vip", vip).put("payment", "integral");
			}
		}
		else{
			//手机号为普通用户
			resp.put("user", nursingVIPServiceImpl.queryNursings(tel))
					.put("payment", "user").put("tel", tel);
		}
		
		return resp;
	}
	
}
