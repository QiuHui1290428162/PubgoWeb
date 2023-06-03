package com.pubgo.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//查询店铺库存
public class QueryCStock {

	@NotNull(message="货号不能为空")
	@Size(min=1, max=20, message="货号不能空")
	private String goodsNo;       //货号
	
	
	private boolean customers;    //是否查询全店库存
	
	
	private int page;             //当前页号 
	
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	public boolean isCustomers() {
		return customers;
	}
	public void setCustomers(boolean customers) {
		this.customers = customers;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
