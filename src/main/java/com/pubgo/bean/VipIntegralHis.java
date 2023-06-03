package com.pubgo.bean;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

//会员积分表
@TableName("VipIntegralHis")
public class VipIntegralHis {

	
	@TableField("VIP")
	private String vip;           //会员号
	@TableField("SaveDate")
	private Date saveDate;        //更新时间
	@TableField("IntegralAmount")
	private int integralAmount;   //积分
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public Date getSaveDate() {
		return saveDate;
	}
	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}
	public int getIntegralAmount() {
		return integralAmount;
	}
	public void setIntegralAmount(int integralAmount) {
		this.integralAmount = integralAmount;
	}
	
	
}
