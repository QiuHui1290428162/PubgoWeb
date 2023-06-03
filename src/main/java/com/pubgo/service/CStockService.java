package com.pubgo.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pubgo.bean.CStock;

//店铺库存表
public interface CStockService {

	//店铺库存
	public IPage<CStock> QueryCustomerStocks(String goodsNo, List<String> customersId, Integer page, Integer rows);
}
