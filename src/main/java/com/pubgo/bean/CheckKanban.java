package com.pubgo.bean;

//销售看板
public class CheckKanban {

	private int vipQuantity;      //新增会员数量
	private double amount;       //总销售金额
	private double vipAmount;    //会员销售金额
	private double average;      //总销售金额客单价
	
	public CheckKanban() {
		this.amount = 0;
		this.average = 0;
		this.vipAmount = 0;
		this.vipQuantity = 0;
	}
	
	public int getVipQuantity() {
		return vipQuantity;
	}
	public void setVipQuantity(int vipQuantity) {
		this.vipQuantity = vipQuantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getVipAmount() {
		return vipAmount;
	}
	public void setVipAmount(double vipAmount) {
		this.vipAmount = vipAmount;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	@Override
	public String toString() {
		return "CheckKanban [vipQuantity=" + vipQuantity + ", amount=" + amount + ", vipAmount=" + vipAmount
				+ ", average=" + average + "]";
	}
	
	
	
	
}
