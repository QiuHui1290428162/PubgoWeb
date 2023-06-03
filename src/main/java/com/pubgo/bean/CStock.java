package com.pubgo.bean;

//店铺库存
public class CStock {

	private String goodsNo;         //货号
	private String customerId;      //店铺号
	private String customerNa;      //店铺名称
	private String range;           //系列
	private String colorId;         //颜色
	private String color;           //颜色名称
	private String size;            //尺码
	private Integer quantity;       //数量
	private String picture;         //图片地址
	
	
	public String getGoodsNo() {
		return goodsNo;
	}


	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getColorId() {
		return colorId;
	}


	public void setColorId(String colorId) {
		this.colorId = colorId;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getRange() {
		return range;
	}


	public void setRange(String range) {
		this.range = range;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	

	public String getCustomerNa() {
		return customerNa;
	}


	public void setCustomerNa(String customerNa) {
		this.customerNa = customerNa;
	}


	@Override
	public String toString() {
		return "CStock [goodsNo=" + goodsNo + ", customerId=" + customerId + ", customerNa=" + customerNa + ", colorId="
				+ colorId + ", color=" + color + ", size=" + size + ", quantity=" + quantity + ", picture=" + picture
				+ "]";
	}
	
	
}
