package com.pubgo.dao;

import java.sql.Date;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pubgo.bean.Vip;
import com.pubgo.request.AddCustomerVipReq;



public interface CustomerVIPDao  extends BaseMapper<Vip> {

	public Vip selectVIPBirthDate( String CustomerID, Date birthDate );
	
	//新增会员信息
	public int insertCustomerVIP(AddCustomerVipReq addCustomerVipReq);
}
