package com.pubgo.service;

import com.pubgo.bean.VipIntegralHis;

//会员积分表
public interface VipIntegralHisService {

	//修改会员积分
	public void editIntegralHis(String vip, int integral, int integralChange
			, String operator, String postUser, String remark);
	
	//查询会员积分
	public VipIntegralHis queryIntegralHis(String vip);
	
	//创建会员积分
	public int addIntegralHis(String vip, int integral);
}
