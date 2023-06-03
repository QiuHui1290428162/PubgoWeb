package com.pubgo.service;

import java.sql.Date;

//积分操作记录表
public interface VIPIntegralExchangeService {

	public void addIntegralOne(String vip, Date exchangeDate
			, int amount, String operator, String remark);
}
