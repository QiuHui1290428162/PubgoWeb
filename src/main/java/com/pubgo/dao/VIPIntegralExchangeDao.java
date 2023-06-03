package com.pubgo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pubgo.bean.VIPIntegralExchange;

//积分操作记录表
public interface VIPIntegralExchangeDao extends BaseMapper<VIPIntegralExchange> {

	public void insertOne(VIPIntegralExchange integralExchange);
}
