package com.pubgo.service;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.pubgo.bean.Vip;
import com.pubgo.request.AddCustomerVipReq;

//vip会员业务层
public interface CustomerVIPService {

	//查询会员
	public Vip queryVipByID(String vip);
	//编辑会员
	public void editVipByID(String vip);
	//编辑会员积分
	public void editVipIntegralByID(String vip, int integral);
	//添加会员
	public void addVipByID(String vip);
	//删除会员
	public void removeVipByID(String vip);
	//新增会员信息
	public int insertCustomerVIP(AddCustomerVipReq addCustomerVipReq)  throws SQLServerException;
}
