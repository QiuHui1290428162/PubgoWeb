package com.pubgo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//护理登记明细
@TableName("NursingDetail")
public class NursingDetail {

	@TableId("NursingDetailID") 
	private String nursingDetailID;    //护理登记明细id
	@TableField("NursingID") 
	private String nursingID;          //id
	@TableField("Item")
	private String item;             //项目
	@TableField("Renge")
	private String renge;            //系列
	@TableField("Number")
	private int number;              //数量
	public String getNursingDetailID() {
		return nursingDetailID;
	}
	public void setNursingDetailID(String nursingDetailID) {
		this.nursingDetailID = nursingDetailID;
	}
	public String getNursingID() {
		return nursingID;
	}
	public void setNursingID(String nursingID) {
		this.nursingID = nursingID;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getRenge() {
		return renge;
	}
	public void setRenge(String renge) {
		this.renge = renge;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "NursingDetail [nursingDetailID=" + nursingDetailID + ", nursingID=" + nursingID + ", item=" + item
				+ ", renge=" + renge + ", number=" + number + "]";
	}
	
	
}
