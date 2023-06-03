package com.pubgo.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pubgo.bean.CStock;
import com.pubgo.dao.CStockDao;
import com.pubgo.service.CStockService;

@Service
//默认不不启动SQL事务控制
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class CStockServiceImpl implements CStockService{

	@Resource 
	private CStockDao dao;
	
	/**
	 * 
	 * @param goodsNo    货号
	 * @param customersId   店铺号
	 * @param page       页数
	 * @param rows       每页行数
	 * @return
	 */
	@Override
	public IPage<CStock> QueryCustomerStocks(String goodsNo, List<String> customersId, Integer page, Integer rows) {
		//配置分页Page
		Page<CStock> p = new Page<>(page, rows);
		//设置排序方式
		p.addOrder(OrderItem.desc("CStock.Customer_Id"),OrderItem.desc("CStock.GOODS_NO"));
		//将查询的结果导入到IPage
		IPage<CStock> iPage = p;
		iPage = dao.selectCStocks(goodsNo, customersId, iPage);
		return p;
	}

	
}
