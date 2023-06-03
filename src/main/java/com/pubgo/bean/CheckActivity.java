package com.pubgo.bean;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//核销单活动视图
@TableName("CheckActivity")
public class CheckActivity {

	@TableId("ID")
	public String id;              //id
	@TableField("CheckID")
	public String checkID;       //核销单号
	@TableField("CustomerName")
	public String customerName;    //店铺名称
	@TableField("BuisnessManName")
	public String buisnessManName; //员工名称
	@TableField("InputDate")
	public Date inputDate;       //录入时间
	@TableField("UnitPrice")
	public double unitPrice;     //销售总金额
	@TableField("DiscountPrice")
	public double discountPrice; //销售总生意额
	@TableField("Quantity")
	public int quantity;         //销售总数量
	@TableField("VIP")
	public String vip;           //会员号
	@TableField("Tel")
	public String tel;           //手机号
	@TableField("Activity")
	public String activity;      //活动名称
	@TableField("Code")
	public String code;          //核销码
	@TableField("PromocardID")
	public Long promocardID;    //活动id
	@TableField("Remark")
	public String remark;        //备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCheckID() {
		return checkID;
	}
	public void setCheckID(String checkID) {
		this.checkID = checkID;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBuisnessManName() {
		return buisnessManName;
	}
	public void setBuisnessManName(String buisnessManName) {
		this.buisnessManName = buisnessManName;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getPromocardID() {
		return promocardID;
	}
	public void setPromocardID(Long promocardID) {
		this.promocardID = promocardID;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "CheckActivity [id=" + id + ", checkID=" + checkID + ", customerName=" + customerName
				+ ", buisnessManName=" + buisnessManName + ", inputDate=" + inputDate + ", unitPrice=" + unitPrice
				+ ", discountPrice=" + discountPrice + ", quantity=" + quantity + ", vip=" + vip + ", tel=" + tel
				+ ", activity=" + activity + ", code=" + code + ", promocardID=" + promocardID + ", remark=" + remark
				+ "]";
	}
	
	
	
}
