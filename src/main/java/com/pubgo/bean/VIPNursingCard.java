package com.pubgo.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//护理卡表
@TableName("VIPNursingCard")
public class VIPNursingCard {

	@TableId("CardID")
	private String cardID;       //卡号-有赞
	@TableField("Vip") 
	private String vip;          //会员号
	@TableField("BegainDate")
	private Date begainDate;     //开始日期
	@TableField("ExpireDate")
	private Date expireDate;     //结束日期
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public String getBegainDateToString() {
		return new SimpleDateFormat("yyyy-MM-dd").format(begainDate);
	}
	public Date getBegainDate() {
		return begainDate;
	}
	public void setBegainDate(Date begainDate) {
		this.begainDate = begainDate;
	}
	public String getExpireDateToString() {
		return new SimpleDateFormat("yyyy-MM-dd").format(expireDate);
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	@Override
	public String toString() {
		return "VIPNursingCard [cardID=" + cardID + ", vip=" + vip + ", begainDate=" + begainDate + ", expireDate="
				+ expireDate + "]";
	}
	
	
}
