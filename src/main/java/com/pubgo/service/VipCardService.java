package com.pubgo.service;

import java.util.List;

import com.pubgo.bean.VipCard;
import com.pubgo.exception.ImoocMallException;

//会员卡业务层
public interface VipCardService {

	public List<VipCard>  selectAll() throws Exception;
	public VipCard  selectVipCardByName(String vipCardByName) throws ImoocMallException;
	public List<VipCard>  selectVipCardByGrade(int vipCardByGrade) throws ImoocMallException;
}
