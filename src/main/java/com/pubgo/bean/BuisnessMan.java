package com.pubgo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//员工信息类
//注解输入数据表名称
@TableName("BuisnessMan")
public class BuisnessMan {
	@TableId("BuisnessManID")
	String buisnessManID;       //员工号
	@TableField("CustomerID")
	String customerID;          //店铺号
	@TableField(exist=false)
	String customerName;          //店铺名称
	@TableField("Name")
	String name;                //员工名称
	public String getBuisnessManID() {
		return buisnessManID;
	}
	public void setBuisnessManID(String buisnessManID) {
		this.buisnessManID = buisnessManID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BuisnessMan [buisnessManID=" + buisnessManID + ", customerID=" + customerID + ", customerName="
				+ customerName + ", name=" + name + "]";
	}
	
	
}
