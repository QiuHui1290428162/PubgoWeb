package com.pubgo.bean;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

//积分操作记录表
@TableName("VIPIntegralExchange")
public class VIPIntegralExchange {

	@TableField("TokenCoilID")
	private int tokenCoilID;      //记录ID
	@TableField("Vip") 
	private String vip;           //会员号           
	@TableField("exchangeDate")  
	private Date exchangeDate;    //操作时间
	@TableField("Amount")
	private int amount;           //更新积分
	@TableField("Operator") 
	private String operator;      //操作人
	@TableField("Input_Date")
	private Date inputDate;       //录入时间
	@TableField("PostedDate")
	private Date postedDate;      //操作时间
	@TableField("PostUser")
	private String postUser;        //操作人
	@TableField("Remark")       
	private String remark;        //备注
	public int getTokenCoilID() {
		return tokenCoilID;
	}
	public void setTokenCoilID(int tokenCoilID) {
		this.tokenCoilID = tokenCoilID;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public Date getExchangeDate() {
		return exchangeDate;
	}
	public void setExchangeDate(Date exchangeDate) {
		this.exchangeDate = exchangeDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public Date getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
	public String getPostUser() {
		return postUser;
	}
	public void setPostUser(String postUser) {
		this.postUser = postUser;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
