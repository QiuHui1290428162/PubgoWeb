package com.pubgo.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

//护理日志
public class NursingLogVO {

	private String logId;            //id
	private String nursingId;        //护理界面id
	private String CustomerNa;       //店铺名称
	private String operator;         //操作人
	private Timestamp createTime;    //创建时间
	private String createTimeToString;     //录入时间字符串
	private String operate;          //操作
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
	public String getCustomerNa() {
		return CustomerNa;
	}
	public void setCustomerNa(String customerNa) {
		CustomerNa = customerNa;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
		//转换时间格式
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.createTimeToString = formatter.format(createTime.getTime());
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
	public String getCreateTimeToString() {
		return createTimeToString;
	}
	public void setCreateTimeToString(String createTimeToString) {
		this.createTimeToString = createTimeToString;
	}
	@Override
	public String toString() {
		return "NursingLogVO [logId=" + logId + ", nursingId=" + nursingId + ", CustomerNa=" + CustomerNa
				+ ", operator=" + operator + ", createTime=" + createTime + ", operate=" + operate + ", remark="
				+ remark + "]";
	}

	
}
