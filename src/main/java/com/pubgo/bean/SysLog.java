package com.pubgo.bean;


import java.sql.Timestamp;

//丽晶操作日志
public class SysLog {

	private int autoid;          //id
	private String clientHost;   //服务器名称
	private String userNo;       //用户
	private Timestamp logTime;   //日志时间
	private String moduleName;   //模块名称
	private String action;       //操作
	private String remark;       //备注
	public int getAutoid() {
		return autoid;
	}
	public void setAutoid(int autoid) {
		this.autoid = autoid;
	}
	public String getClientHost() {
		return clientHost;
	}
	public void setClientHost(String clientHost) {
		this.clientHost = clientHost;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public Timestamp getLogTime() {
		return logTime;
	}
	public void setLogTime(Timestamp logTime) {
		this.logTime = logTime;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
}
