package com.pubgo.api.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

//会员卡事件消息体
public class ScrmCustomerCardMsg {

	@JsonProperty("card_no")
	public String cardNo;       //用户领取到的会员卡卡号
	@JsonProperty("yz_open_id")
	public String yzOpenId;     //有赞openId
	@JsonProperty("mobile")
	public String mobile;       //手机号
	@JsonProperty("card_alias")
	public String cardAlias;    //会员卡别名，商家会员卡的唯一标识
	@JsonProperty("event_time")
	public String eventTime;    //事件发生时间
	
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getYzOpenId() {
		return yzOpenId;
	}
	public void setYzOpenId(String yzOpenId) {
		this.yzOpenId = yzOpenId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCardAlias() {
		return cardAlias;
	}
	public void setCardAlias(String cardAlias) {
		this.cardAlias = cardAlias;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	
	@Override
	public String toString() {
		return "ScrmCustomerCardMsg [cardNo=" + cardNo + ", yzOpenId=" + yzOpenId + ", mobile=" + mobile
				+ ", cardAlias=" + cardAlias + ", eventTime=" + eventTime + "]";
	}
	
	
}
