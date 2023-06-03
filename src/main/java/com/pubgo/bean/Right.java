package com.pubgo.bean;

import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//用户管理表
@TableName("Right")
public class Right {
	
	@TableId("UserNo")
	private String userNo;             //用户号
	@TableField("UserName")
	private String userName;           //用户名
	@TableField(exist=false)
	private List<String> customers;    //店铺集合
	
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getCustomers() {
		return customers;
	}
	public void setCustomerId(List<String> customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "Right [userNo=" + userNo + ", userName=" + userName + ", customers=" + customers + "]";
	}
	
	
}
