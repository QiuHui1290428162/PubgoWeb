package com.pubgo.bean;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

//核销表
@TableName("Check")
public class Check {

	@TableField("CheckID")
	public String checkID;         //核销单
	@TableField("Warehouse_No")
	public String warehouseNo;     //核销仓库
	@TableField("Customer_ID")
	public String customerID;      //店铺号
	@TableField("ClassName")
	public String className;       //班次
	@TableField("CheckDate")
	public Date checkDate;         //核销时间
	@TableField("Remark")
	public String remark;          //备注
	@TableField("Modi_Date")
	public Date modiDate;          //修改日期
	@TableField("Operator")
	public String operator;        //操作员
	@TableField("CheckQt")
	public int checkQt;            //商品总数
	@TableField("PaymentWay") 
	public String paymentWay;      //付款方式一
	@TableField("PaymentWay1") 
	public String paymentWay1;     //付款方式二
	@TableField("VIP_Card")
	public String vipCard;         //会员卡
	@TableField("Class")
	public String classs;          //班次
	@TableField("Type")
	public int type;               //自动脚本扫描次数
	@TableField("Status")      
	public byte status;            //销售状态
	@TableField("Posted")
	public byte posted;            //审核
	@TableField("PostedDate")
	public Date postedDate;        //审核日期
	@TableField("PostUser")
	public String postUser;        //审核人
	@TableField("Money")
	public double money;           //付款方式一的金额
	@TableField("Money1")
	public double money1;          //付款方式二的金额
	@TableField("Input_Date")
	public Date inputDate;         //录入时间
	@TableField("BuisnessManID")
	public String buisnessManID;   //营业员
	@TableField("Manual_ID")
	public String manualID;        //手工单号
	@TableField("CheckTime")
	public Date checkTime;         //核销日期
	@TableField("TotalMoney")
	public double totalMoney;      //消费者所付的总金额
	@TableField("FormulaID")
	public String formulaID;       //结算公式
	@TableField("Stamp")
	public int stamp;              //印花数
	@TableField("UsedStamp")
	public int usedStamp;          //使用印花数
	@TableField("BuyType")
	public String buyType;         //销售方式
	@TableField("PaymentWay2")
	public String paymentWay2;     //付款方式3
	@TableField("PaymentWay3")
	public String paymentWay3;     //付款方式4
	@TableField("Money2")
	public double money2;          //付款方式3的金额
	@TableField("Money3")
	public double money3;          //付款方式4的金额
	@TableField("MachineID")
	public String machineID;
	@TableField("IntegralAmount")
	public double integralAmount;  //本单积分
	@TableField("TokenCoilAmount")
	public double tokenCoilAmount;
	@TableField("DiscountAmount")
	public double discountAmount;
	@TableField(exist=false)
	public double unitPrice;       //销售总金额
	@TableField(exist=false)
	public double discountPrice;   //销售总生意额
	@TableField(exist=false)
	public int quantity;           //销售商品数量
	public String getCheckID() {
		return checkID;
	}
	public void setCheckID(String checkID) {
		this.checkID = checkID;
	}
	public String getWarehouseNo() {
		return warehouseNo;
	}
	public void setWarehouseNo(String warehouseNo) {
		this.warehouseNo = warehouseNo;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getModiDate() {
		return modiDate;
	}
	public void setModiDate(Date modiDate) {
		this.modiDate = modiDate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public int getCheckQt() {
		return checkQt;
	}
	public void setCheckQt(int checkQt) {
		this.checkQt = checkQt;
	}
	public String getPaymentWay() {
		return paymentWay;
	}
	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}
	public String getPaymentWay1() {
		return paymentWay1;
	}
	public void setPaymentWay1(String paymentWay1) {
		this.paymentWay1 = paymentWay1;
	}
	public String getVipCard() {
		return vipCard;
	}
	public void setVipCard(String vipCard) {
		this.vipCard = vipCard;
	}
	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public byte getPosted() {
		return posted;
	}
	public void setPosted(byte posted) {
		this.posted = posted;
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getMoney1() {
		return money1;
	}
	public void setMoney1(double money1) {
		this.money1 = money1;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public String getBuisnessManID() {
		return buisnessManID;
	}
	public void setBuisnessManID(String buisnessManID) {
		this.buisnessManID = buisnessManID;
	}
	public String getManualID() {
		return manualID;
	}
	public void setManualID(String manualID) {
		this.manualID = manualID;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getFormulaID() {
		return formulaID;
	}
	public void setFormulaID(String formulaID) {
		this.formulaID = formulaID;
	}
	public int getStamp() {
		return stamp;
	}
	public void setStamp(int stamp) {
		this.stamp = stamp;
	}
	public int getUsedStamp() {
		return usedStamp;
	}
	public void setUsedStamp(int usedStamp) {
		this.usedStamp = usedStamp;
	}
	public String getBuyType() {
		return buyType;
	}
	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}
	public String getPaymentWay2() {
		return paymentWay2;
	}
	public void setPaymentWay2(String paymentWay2) {
		this.paymentWay2 = paymentWay2;
	}
	public String getPaymentWay3() {
		return paymentWay3;
	}
	public void setPaymentWay3(String paymentWay3) {
		this.paymentWay3 = paymentWay3;
	}
	public double getMoney2() {
		return money2;
	}
	public void setMoney2(double money2) {
		this.money2 = money2;
	}
	public double getMoney3() {
		return money3;
	}
	public void setMoney3(double money3) {
		this.money3 = money3;
	}
	public String getMachineID() {
		return machineID;
	}
	public void setMachineID(String machineID) {
		this.machineID = machineID;
	}
	public double getIntegralAmount() {
		return integralAmount;
	}
	public void setIntegralAmount(double integralAmount) {
		this.integralAmount = integralAmount;
	}
	public double getTokenCoilAmount() {
		return tokenCoilAmount;
	}
	public void setTokenCoilAmount(double tokenCoilAmount) {
		this.tokenCoilAmount = tokenCoilAmount;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
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
	@Override
	public String toString() {
		return "Check [checkID=" + checkID + ", warehouseNo=" + warehouseNo + ", customerID=" + customerID
				+ ", className=" + className + ", checkDate=" + checkDate + ", remark=" + remark + ", modiDate="
				+ modiDate + ", operator=" + operator + ", checkQt=" + checkQt + ", paymentWay=" + paymentWay
				+ ", paymentWay1=" + paymentWay1 + ", vipCard=" + vipCard + ", classs=" + classs + ", type=" + type
				+ ", status=" + status + ", posted=" + posted + ", postedDate=" + postedDate + ", postUser=" + postUser
				+ ", money=" + money + ", money1=" + money1 + ", inputDate=" + inputDate + ", buisnessManID="
				+ buisnessManID + ", manualID=" + manualID + ", checkTime=" + checkTime + ", totalMoney=" + totalMoney
				+ ", formulaID=" + formulaID + ", stamp=" + stamp + ", usedStamp=" + usedStamp + ", buyType=" + buyType
				+ ", paymentWay2=" + paymentWay2 + ", paymentWay3=" + paymentWay3 + ", money2=" + money2 + ", money3="
				+ money3 + ", machineID=" + machineID + ", integralAmount=" + integralAmount + ", tokenCoilAmount="
				+ tokenCoilAmount + ", discountAmount=" + discountAmount + ", unitPrice=" + unitPrice
				+ ", discountPrice=" + discountPrice + ", quantity=" + quantity + "]";
	}
	
	
	
}






















