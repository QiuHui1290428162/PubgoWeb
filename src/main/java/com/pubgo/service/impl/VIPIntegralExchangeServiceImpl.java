package com.pubgo.service.impl;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.pubgo.bean.VIPIntegralExchange;
import com.pubgo.dao.VIPIntegralExchangeDao;
import com.pubgo.service.VIPIntegralExchangeService;

//新增积分操作记录
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class VIPIntegralExchangeServiceImpl implements VIPIntegralExchangeService {

	@Resource
	private VIPIntegralExchangeDao vipIntegralExchangeDao;

	/**
	 * 	新增积分操作
	 * @param vip   会员号
	 * @param exchangeDate   录入时间
	 * @param amount   更新积分
	 * @param postUser   操作人
	 * @param remark   备注
	 * @return   
	 */
    @Transactional(rollbackFor = Exception.class)
	@Override
	public void addIntegralOne(String vip, Date exchangeDate
			, int amount, String postUser, String remark) {
		
		VIPIntegralExchange integralExchange = new VIPIntegralExchange();  
		integralExchange.setVip(vip);
		integralExchange.setExchangeDate(exchangeDate);
		integralExchange.setInputDate(exchangeDate);
		integralExchange.setPostedDate(exchangeDate);
		integralExchange.setOperator(postUser);
		integralExchange.setAmount(amount);
		integralExchange.setPostUser(postUser);
		integralExchange.setRemark(remark);
		
		vipIntegralExchangeDao.insert(integralExchange);
	}

	

	

}
