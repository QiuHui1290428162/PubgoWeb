package com.pubgo.bean;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//护理日志
@TableName("NursingLog")
public class NursingLog {

	@TableId("LogId")
	private String logId;            //id
	@TableField("NursingId")
	private String nursingId;        //护理界面id
	@TableField("Customer_ID")
	private String customerID;       //店铺号
	@TableField("Operator")
	private String operator;         //操作人
	@TableField("CreateTime")
	private Date createTime;         //创建时间
	@TableField("Operate")
	private String operate;          //操作
	@TableField("Remark")
	private String remark;           //备注
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getNursingId() {
		return nursingId;
	}
	public void setNursingId(String nursingId) {
		this.nursingId = nursingId;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "NursingLog [logId=" + logId + ", nursingId=" + nursingId + ", customerID=" + customerID + ", operator="
				+ operator + ", createTime=" + createTime + ", operate=" + operate + ", remark=" + remark + "]";
	}


	
}
