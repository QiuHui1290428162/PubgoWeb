package com.pubgo.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pubgo.utils.Constant;
import com.pubgo.utils.ResponseUtil;
import com.pubgo.utils.UserUtil;
import com.pubgo.property.InformationProperty;
import com.pubgo.request.QueryCStock;
import com.pubgo.service.CStockService;

/**
 * 	库存查询控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/stock/query/")
public class CStockController {
	@Resource
	private CStockService cstockServiceImpl;

	@Resource
	private UserUtil userUtil;
	
	@Resource
	public InformationProperty informationProperty;
	/**
	 * 
	 * @param queryCStock    库存查询条件参数
	 * @param page           当前页号
	 * @param session    
	 * @return
	 */
	@PostMapping("goodsNo")
	public ResponseUtil checkLogin(@Valid @RequestBody QueryCStock queryCStock
			, HttpSession session) {
		ResponseUtil resp = null;
		
		//判断是否全店查询，true为全店查询，flase为账号权限查询
		if ( queryCStock.isCustomers() ) {
			resp = new ResponseUtil().put("stock"
					, cstockServiceImpl.QueryCustomerStocks(queryCStock.getGoodsNo()
							, null, queryCStock.getPage(), informationProperty.getRows()));
		}else {
			resp = new ResponseUtil().put("stock"
					, cstockServiceImpl.QueryCustomerStocks(queryCStock.getGoodsNo()
					, userUtil.getCustomersID((String)session.getAttribute(Constant.ID)
							,(String)session.getAttribute(Constant.TYPE))
					, queryCStock.getPage(), informationProperty.getRows()));
		}
		
		
		return resp;
		
	}

}
 