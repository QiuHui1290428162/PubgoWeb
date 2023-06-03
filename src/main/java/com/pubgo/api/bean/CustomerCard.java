package com.pubgo.api.bean;

import java.util.Date;

//会员权益卡
public class CustomerCard {

	public Date startDate;    //有效期开始时间
	public Date endDate;      //有效期结束时间
	private String alias;     //权益卡唯一别名
	private String cardNo;    //权益卡号
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	@Override
	public String toString() {
		return "CustomerCard [startDate=" + startDate + ", endDate=" + endDate + ", alias="
				+ alias + ", cardNo=" + cardNo + "]";
	}
	
	
}
