package com.pubgo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pubgo.bean.CStock;

public interface CStockDao extends BaseMapper<CStock> {

	//分页查询库存
	public IPage<CStock> selectCStocks(String goodsNo
			, @Param(value = "customersId") List<String> customersId, IPage<CStock> page);
}
