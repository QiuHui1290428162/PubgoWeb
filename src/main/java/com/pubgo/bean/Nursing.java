package com.pubgo.bean;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//护理登记表
@TableName("Nursing")
public class Nursing {

	@TableId("NursingID")
	private String nursingID;        //id
	@TableField("Tel")
	private String tel;              //手机号
	@TableField("[Name]")
	private String userName;         //用户姓名,需转义
	@TableField("Customer_ID")
	private String customerID;       //店铺号
	@TableField("Quantity")
	private int quantity;            //数量
	@TableField("Step")
    private int step;                //护理步骤
	@TableField("Score")
	private int score;               //评分
	@TableField("Appraise")
	private String appraise;         //评价
	@TableField("Input")
	private int input;               //录入方式   0—后台， 1—前台
	@TableField("Payment")
	private String payment;          //结算方式，nursingCard护理卡，integral积分，user用户
	@TableField("UserRemake")
	private String userRemake;       //用户备注
	@TableField("EmployeeRemake")
	private String employeeRemake;   //员工备注
	@TableField("CreateTime")
	private Date createTime;         //创建时间
	@TableField("UpdateTime")
    private Date updateTime;         //修改时间
	@TableField("Sign")
    private String sign;             //停用标志  0-停用   1-启用
	public String getNursingID() {
		return nursingID;
	}
	public void setNursingID(String nursingID) {
		this.nursingID = nursingID;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getInput() {
		return input;
	}
	public void setInput(int input) {
		this.input = input;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getAppraise() {
		return appraise;
	}
	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public String getUserRemake() {
		return userRemake;
	}
	public void setUserRemake(String userRemake) {
		this.userRemake = userRemake;
	}
	public String getEmployeeRemake() {
		return employeeRemake;
	}
	public void setEmployeeRemake(String employeeRemake) {
		this.employeeRemake = employeeRemake;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public String toString() {
		return "Nursing [nursingID=" + nursingID + ", tel=" + tel + ", name=" + userName + ", customerID=" + customerID
				+ ", quantity=" + quantity + ", step=" + step + ", score=" + score + ", appraise=" + appraise
				+ ", input=" + input + ", payment=" + payment + ", userRemake=" + userRemake + ", employeeRemake="
				+ employeeRemake + ", createTime=" + createTime + ", updateTime=" + updateTime + ", sign=" + sign + "]";
	}
	
	
}
